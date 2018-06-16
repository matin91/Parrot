package com.rocklobstre.causalarm.alarmdetail;

import com.rocklobstre.causalarm.base.BasePresenter;
import com.rocklobstre.causalarm.base.BaseView;
import com.rocklobstre.causalarm.data.viewmodel.Alarm;

/**
 * Created by Ryan on 06/03/2017.
 */

public interface AlarmDetailContract {
    interface View extends BaseView {
        Alarm getViewModel();

        void setAlarmTitle(String title);

        void setVibrateOnly(boolean active);

        void setRenewAutomatically(boolean active);

        void setPickerTime(int hour, int minute);

        void setCurrentAlarmState(boolean active);

        String getAlarmId();

        void startAlarmListActivity();

    }

    interface Presenter extends BasePresenter {
        void onBackIconPress();

        void onDoneIconPress();
    }
}
