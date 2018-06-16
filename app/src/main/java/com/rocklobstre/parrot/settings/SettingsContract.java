package com.rocklobstre.parrot.settings;

import com.rocklobstre.parrot.base.BasePresenter;
import com.rocklobstre.parrot.base.BaseView;

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
