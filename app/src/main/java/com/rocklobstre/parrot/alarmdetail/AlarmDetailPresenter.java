package com.rocklobstre.parrot.alarmdetail;


import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.data.alarmdatabase.AlarmSource;
import com.rocklobstre.parrot.data.retrofit.executor.PostExecutionThread;
import com.rocklobstre.parrot.data.retrofit.executor.ThreadExecutor;
import com.rocklobstre.parrot.data.retrofit.repository.AlarmRepository;
import com.rocklobstre.parrot.data.viewmodel.Alarm;
import com.rocklobstre.parrot.data.viewmodel.Reason;
import com.rocklobstre.parrot.usecase.subscriber.BaseSubscriber;
import com.rocklobstre.parrot.usecase.GetAlarm;
import com.rocklobstre.parrot.usecase.GetReasons;
import com.rocklobstre.parrot.usecase.UpdateOrCreateAlarm;
import com.rocklobstre.parrot.util.BaseSchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Ryan on 05/03/2017.
 */

public class AlarmDetailPresenter implements AlarmDetailContract.Presenter {

    //Use Cases
    private final GetAlarm getAlarm;
    private final UpdateOrCreateAlarm updateOrCreateAlarm;
    private final GetReasons getReasons;


    private final AlarmDetailContract.View view;
    private final BaseSchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;

    //Constructor Injection: What is a use case for Constructor Injection?
    @Inject
    public AlarmDetailPresenter(AlarmDetailContract.View view,
                                AlarmSource alarmSource,
                                AlarmRepository alarmRepository,
                                BaseSchedulerProvider schedulerProvider,
                                ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread
                                ) {
        this.getAlarm = new GetAlarm(alarmSource);
        this.getReasons = new GetReasons(alarmRepository);
        this.updateOrCreateAlarm = new UpdateOrCreateAlarm(alarmSource);
        this.view = view;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = new CompositeDisposable();
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public void start() {
        getReminder();
    }

    @Override
    public void stop() {
        compositeDisposable.clear();
    }

    public void getReminder(){
        compositeDisposable.add(
                getAlarm.runUseCase(view.getAlarmId())
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(
                                new DisposableSubscriber<Alarm>() {
                                    @Override
                                    public void onNext(Alarm alarm) {
                                        view.setAlarmTitle(alarm.getAlarmTitle());
                                        view.setAlarmMessage(alarm.getAlarmMessage());
                                        view.setVibrateOnly(alarm.isVibrateOnly());
                                        view.setRenewAutomatically(alarm.isRenewAutomatically());
                                        view.setPickerTime(alarm.getHourOfDay(), alarm.getMinute());
                                        view.setCurrentAlarmState(alarm.isActive());
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        view.makeToast(R.string.error_invalid_alarm_id);
                                        view.startAlarmListActivity();
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                })
        );

    }

    @Override
    public void onBackIconPress() {
        view.startAlarmListActivity();
    }

    /**
     * Ensure that the RealmAlarm is updated in repository
     */
    @Override
    public void onDoneIconPress() {
        Alarm alarm = view.getViewModel();
        alarm.setAlarmId(view.getAlarmId());

        compositeDisposable.add(
                updateOrCreateAlarm.runUseCase(alarm)
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .subscribeWith(
                                new DisposableCompletableObserver() {
                                    @Override
                                    public void onComplete() {
                                        view.makeToast(R.string.message_database_write_successful);
                                        view.startAlarmListActivity();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        view.makeToast(R.string.error_database_write_failure);
                                    }
                                })
        );
    }

    @Override
    public void onTestMessageIconPress() {
        view.startSpeakingMessage();
    }

    @Override
    public void onClearMessageIconPress() {
        view.setAlarmMessage("");
    }

    @Override
    public void onLoadReasonsIconPress() {
        compositeDisposable.add(
                getReasons.runUseCase()
                        .subscribeOn(Schedulers.from(threadExecutor))
                        .observeOn(postExecutionThread.getScheduler())
                        .subscribeWith(new ReasonsSubscriber())
        );
    }

    protected class ReasonsSubscriber extends BaseSubscriber<List<Reason>> {

        @Override
        public void onError(Throwable e) {
            super.onError(e);
        }

        @Override public void onNext(List<Reason> reasons) {
            view.setAlarmMessage(reasons.get(1).getReasonMessage());
            view.startSpeakingMessage();
        }
    }

}
