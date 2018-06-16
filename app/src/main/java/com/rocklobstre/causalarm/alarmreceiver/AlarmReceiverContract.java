package com.rocklobstre.causalarm.alarmreceiver;

import com.rocklobstre.causalarm.base.BasePresenter;
import com.rocklobstre.causalarm.base.BaseView;
import com.rocklobstre.causalarm.data.viewmodel.Alarm;

/**
 * Created by Ryan on 05/03/2017.
 */

public interface AlarmReceiverContract {
    interface View extends BaseView {
            String getAlarmId();

            Alarm getViewModel();

            void finishActivity();
    }

    interface Presenter extends BasePresenter {
        void onAlarmDismissClick();

    }
}
