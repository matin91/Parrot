package com.rocklobstre.parrot.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.rocklobstre.parrot.settings.DaggerSettingsComponent;
import com.rocklobstre.parrot.ParrotApplication;
import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.alarmlist.AlarmListActivity;

import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by Ryan on 05/03/2017.
 */

public class SettingsFragment extends Fragment implements SettingsContract.View {

    @Inject
    SettingsPresenter settingsPresenter;

    private ImageButton back;
    private LottieAnimationView androidLottie;

    public SettingsFragment() {

    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        DaggerSettingsComponent.builder()
                .settingsPresenterModule(new SettingsPresenterModule(this))
                .applicationComponent(
                        ((ParrotApplication) getActivity().getApplication())
                                .getApplicationComponent()
                )
                .build().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        back = (ImageButton) v.findViewById(R.id.imb_settings_back);
        androidLottie = (LottieAnimationView) v.findViewById(R.id.animation_view);
        TextView verion = (TextView) v.findViewById(R.id.lbl_settings_version);

        verion.setText(getResources().getString(R.string.settings_version_number) + getVersionString());
        lottieProgressConfig(androidLottie);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsPresenter.onBackButtonPress();
            }
        });
        return v;
    }

    public String getVersionString(){
        PackageInfo pInfo = null;
        try {
            pInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return pInfo.versionName;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void makeToast(@StringRes int message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void startAlarmListActivity() {
        Intent i = new Intent(getActivity(), AlarmListActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void lottieProgressConfig(final LottieAnimationView animationView) {
        animationView.loop(false);
        LottieComposition.Factory.fromAssetFileName(Objects.requireNonNull(getActivity()), "android.json",
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
