package com.rocklobstre.parrot.alarmreceiver;

import com.rocklobstre.parrot.base.BasePresenter;
import com.rocklobstre.parrot.base.BaseView;
import com.rocklobstre.parrot.data.viewmodel.Alarm;

/**
 * Created by Ryan on 05/03/2017.
 */

public interface AlarmReceiverContract {
    interface View extends BaseView {
            String getAlarmId();

            Alarm getViewModel();

            void finishActivity();

            void startSpeakingMessage(String message);
    }

    interface Presenter extends BasePresenter {
        void onAlarmDismissClick();

    }
}
