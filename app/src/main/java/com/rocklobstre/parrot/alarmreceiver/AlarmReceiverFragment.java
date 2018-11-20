package com.rocklobstre.parrot.alarmreceiver;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.alarmreceiver.DaggerAlarmReceiverComponent;
import com.rocklobstre.parrot.ParrotApplication;
import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by Matin on 05/03/2017.
 */

public class AlarmReceiverFragment extends Fragment implements AlarmReceiverContract.View {

    private static final String ALARM_ID = "ALARM_ID";
    private String alarmId;

    @Inject
    AlarmReceiverPresenter presenter;
    @Inject
    Speakerbox speakerbox;

    private TextView dateview;
    private TextView messageview;

    public AlarmReceiverFragment() {

    }

    public static AlarmReceiverFragment newInstance(String alarmId) {
        AlarmReceiverFragment fragment = new AlarmReceiverFragment();
        Bundle args = new Bundle();
        args.putString(ALARM_ID, alarmId);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.alarmId = getArguments().getString(ALARM_ID);
        setRetainInstance(true);

        DaggerAlarmReceiverComponent.builder()
                .alarmReceiverPresenterModule(new AlarmReceiverPresenterModule(this))
                .applicationComponent(
                        ((ParrotApplication) getActivity().getApplication())
                                .getApplicationComponent()
                )
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm, container, false);

        Button stopAlarm = (Button) v.findViewById(R.id.btn_alarm_dismiss);
        LottieAnimationView animationView = (LottieAnimationView) v.findViewById(R.id.animation_view);
        dateview = (TextView)v.findViewById(R.id.date);
        messageview = (TextView)v.findViewById(R.id.message);

        lottieProgressConfig(animationView);

        stopAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAlarmDismissClick();
            }
        });

        speakerbox.setActivity(getActivity());
        speakerbox.getTextToSpeech().setLanguage(new Locale("en_US"));
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void makeToast(@StringRes int message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_SHORT)
                .show();
    }


    @Override
    public void onResume() {
        super.onResume();
        /*
                In order to set up the Presenter properly, it must be supplied with the Id of the
                Alarm which just went off.
                 */
        presenter.start();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        finishActivity();
    }

    public String getAlarmId() {
        return this.alarmId;
    }

    @Override
    public Alarm getViewModel() {
       return new Alarm(
                this.alarmId,
                getString(R.string.def_alarm_name),
               getString(R.string.def_alarm_message),
                false,
                false,
                true,
                12,
                30
        );
    }

    @Override
    public void finishActivity() {
        speakerbox.abandonAudioFocus();
        speakerbox.stop();
        Activity activity = getActivity();

        //null check to avoid cases where Act is destroyed. Not sure if necessary at this point.
        if (activity != null) {
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }


    @Override
    public void startSpeakingMessage(final String message) {
        final Runnable onStart = new Runnable() {
            public void run() {
                speakerbox.requestAudioFocus();
            }
        };
        final Runnable onDone = new Runnable() {
            public void run() {
                speakerbox.abandonAudioFocus();
                startSpeakingMessage(message);
            }
        };
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                speakerbox.play(message, onStart, onDone, null);
            }
        }, 3000);

        //show message
        messageview.setText(message);

        //show date
        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm");//formating according to my need
        String date = formatter.format(today);
        dateview.setText(date);
    }

    private void lottieProgressConfig(final LottieAnimationView animationView) {
        animationView.loop(true);
        LottieComposition.Factory.fromAssetFileName(Objects.requireNonNull(getActivity()), "_alarm.json",
                new OnCompositionLoadedListener() {
                    @Override public void onCompositionLoaded(LottieComposition composition) {
                        animationView.setComposition(composition);
                    }
                });

        if (animationView.getProgress() == 1f) {
            animationView.setProgress(0f);
        }
        animationView.resumeAnimation();

    }
}
