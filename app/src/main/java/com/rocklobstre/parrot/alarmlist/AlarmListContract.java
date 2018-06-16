package com.rocklobstre.parrot.alarmlist;

import com.rocklobstre.parrot.base.BasePresenter;
import com.rocklobstre.parrot.base.BaseView;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import java.util.List;

/**
 * Created by Ryan on 06/03/2017.
 */

public interface AlarmListContract {
    interface View extends BaseView {
        void setAlarmListData(List<Alarm> alarmListData);

        void setNoAlarmListDataFound();

        void addNewAlarmToListView(Alarm alarm);

        void startAlarmDetailActivity(String alarmId);

        void startSettingsActivity();

        void showUndoSnackbar();

        void insertAlarmAt(int position, Alarm alarm);


    }

    interface Presenter extends BasePresenter {
        void onAlarmToggled(boolean active, Alarm alarm);

        void onSettingsIconClick();

        void onAlarmSwiped(int index, Alarm alarm);

        void onAlarmIconClick(Alarm alarm);

        void onCreateAlarmButtonClick(int currentNumberOfAlarms, Alarm alarm);

        void onUndoConfirmed();

        void onSnackbarTimeout();


    }
}
