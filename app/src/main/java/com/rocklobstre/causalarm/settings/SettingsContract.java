package com.rocklobstre.causalarm.settings;

import com.rocklobstre.causalarm.base.BasePresenter;
import com.rocklobstre.causalarm.base.BaseView;

/**
 * Created by Ryan on 09/03/2017.
 */

public interface SettingsContract {
    interface View extends BaseView {
        void startAlarmListActivity();
    }

    interface Presenter extends BasePresenter {
        void onBackButtonPress();
    }
}
