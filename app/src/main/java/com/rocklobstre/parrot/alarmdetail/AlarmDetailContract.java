package com.rocklobstre.parrot.alarmdetail;

import com.rocklobstre.parrot.base.BasePresenter;
import com.rocklobstre.parrot.base.BaseView;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

/**
 * Created by Ryan on 06/03/2017.
 */

public interface AlarmDetailContract {
    interface View extends BaseView {
        Alarm getViewModel();

        void setAlarmTitle(String title);

        void setAlarmMessage(String message);

        void setVibrateOnly(boolean active);

        void setRenewAutomatically(boolean active);

        void setPickerTime(int hour, int minute);

        void setCurrentAlarmState(boolean active);

        String getAlarmId();

        void startAlarmListActivity();

        void startSpeakingMessage();

    }

    interface Presenter extends BasePresenter {
        void onBackIconPress();

        void onDoneIconPress();

        void onTestMessageIconPress();

        void onClearMessageIconPress();

        void onLoadReasonsIconPress();

    }
}
