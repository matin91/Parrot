package com.rocklobstre.parrot.alarmdetail;

import android.animation.ObjectAnimator;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.anthonyfdev.dropdownview.DropDownView;
import com.mapzen.speakerbox.Speakerbox;
import com.rocklobstre.parrot.ParrotApplication;
import com.rocklobstre.parrot.R;
import com.rocklobstre.parrot.data.viewmodel.Alarm;
import com.rocklobstre.parrot.alarmlist.AlarmListActivity;
import com.rocklobstre.parrot.data.viewmodel.Reason;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;


/**
 * I treat my Fragments as Views
 * Created by Matin on 08/08/2016.
 */
public class AlarmDetailFragment extends Fragment implements AlarmDetailContract.View {
    private static final String ALARM_TO_BE_EDITED = "ALARM_TO_BE_EDITED";
    public static int REQUEST_CODE = 42;
    public static String NOTIFICATION_GROUP_KEY = "reminders";

    @Inject
    AlarmDetailPresenter presenter;

    private EditText alarmTitle;
    private EditText alarmMessage;
    private CheckBox vibrateOnly, autoRenew;
    private TimePicker nosePicker;
    private ImageView back, proceed, clearMessage;

    private String alarmId;
    private boolean currentAlarmState;

    private DropDownView dropDownView;
    private RecyclerView recyclerView;
    private DropDownAdapter adapter;
    private int selectedStandId;
    private ImageView headerChevronIV;
    private DropDownAdapter.ViewActions viewActions;
    private TextView dropDownHeaderTitle;

    public AlarmDetailFragment() {
    }

    public static AlarmDetailFragment newInstance(String alarmId) {
        AlarmDetailFragment fragment = new AlarmDetailFragment();
        Bundle args = new Bundle();
        args.putString(ALARM_TO_BE_EDITED, alarmId);
        fragment.setArguments(args);
        return fragment;
    }

        /*------------------------------- Lifecycle -------------------------------*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        this.alarmId = getArguments().getString(ALARM_TO_BE_EDITED);

        DaggerAlarmDetailComponent.builder()
                .alarmDetailPresenterModule(new AlarmDetailPresenterModule(this))
                .applicationComponent(
                        ((ParrotApplication) getActivity().getApplication())
                                .getApplicationComponent()
                )
                .build().inject(this);

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_alarm_detail, container, false);

        alarmTitle = (EditText) v.findViewById(R.id.edt_alarm_title);
        alarmMessage = (EditText) v.findViewById(R.id.edt_alarm_message);
        nosePicker = (TimePicker) v.findViewById(R.id.pck_alarm_time);
        vibrateOnly = (CheckBox) v.findViewById(R.id.chb_vibrate_only);
        autoRenew = (CheckBox) v.findViewById(R.id.chb_renew_automatically);
        back = (ImageButton) v.findViewById(R.id.imb_alarm_detail_back);
        clearMessage = (ImageButton) v.findViewById(R.id.imb_clear_alarm_message);
        proceed = (ImageButton) v.findViewById(R.id.imb_alarm_detail_proceed);
        View scrollDown = v.findViewById(R.id.imb_alarm_scroll_bottom);
        ScrollView scrollLayout = (ScrollView)v.findViewById(R.id.scrl_alarm_detail);

        setUpDropDownViews(v);

        scrollDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollLayout.fullScroll(View.FOCUS_DOWN);
                dropDownView.expandDropDown();
                clearMessage.callOnClick();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackIconPress();
            }
        });

        clearMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearMessageIconPress();
            }
        });

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDoneIconPress();
            }
        });

        return v;
    }

    private void setUpDropDownViews(View v) {
        dropDownView = (DropDownView) v.findViewById(R.id.drop_down_view);
        View collapsedView = LayoutInflater.from(getActivity()).inflate(R.layout.item_header_drop_down, null, false);
        View expandedView = LayoutInflater.from(getActivity()).inflate(R.layout.item_expanded_drop_down, null, false);
        recyclerView = (RecyclerView) expandedView.findViewById(R.id.recyclerView);
        headerChevronIV = (ImageView) collapsedView.findViewById(R.id.chevron_image);
        dropDownHeaderTitle = (TextView) collapsedView.findViewById(R.id.selected_stand_title);
        dropDownView.setHeaderView(collapsedView);
        dropDownView.setExpandedView(expandedView);
        dropDownView.setDropDownListener(dropDownListener);
    }

    private final DropDownView.DropDownListener dropDownListener = new DropDownView.DropDownListener() {
        @Override
        public void onExpandDropDown() {
            if (adapter == null) {
                dropDownHeaderTitle.setText(getResources().getString(R.string.loading));
                presenter.onDropDownExpand();
            } else
                adapter.notifyDataSetChanged();
            ObjectAnimator.ofFloat(headerChevronIV, View.ROTATION.getName(), 180).start();
        }

        @Override
        public void onCollapseDropDown() {
            ObjectAnimator.ofFloat(headerChevronIV, View.ROTATION.getName(), -180, 0).start();
        }
    };



    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /*------------------------------- Contract -------------------------------*/

    @Override
    public Alarm getViewModel() {
        Alarm alarm = new Alarm();

        alarm.setAlarmId(alarmId);
        alarm.setAlarmTitle(alarmTitle.getText().toString());
        alarm.setAlarmMessage(alarmMessage.getText().toString());
        alarm.setMinute(getPickerMinute());
        alarm.setHourOfDay(getPickerHour());
        alarm.setActive(false);
        alarm.setRenewAutomatically(getRenewAutomatically());
        alarm.setVibrateOnly(getVibrateOnly());

        return alarm;
    }

    @Override
    public void setAlarmTitle(String title) {
        alarmTitle.setText(title);
    }

    @Override
    public void setAlarmMessage(String message) {
        alarmMessage.setText(message);
    }

    @Override
    public void setVibrateOnly(boolean active) {
        vibrateOnly.setChecked(active);
    }

    @Override
    public void setRenewAutomatically(boolean active) {
        autoRenew.setChecked(active);
    }

    @Override
    public void setPickerTime(int hour, int minute) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            nosePicker.setHour(hour);
            nosePicker.setMinute(minute);
        } else {
            nosePicker.setCurrentHour(hour);
            nosePicker.setCurrentMinute(minute);
        }
    }

    /**
     * Knowing if the Alarm is Active or not is very important
     *
     * @param active can be: true (active) or false (inactive
     */
    @Override
    public void setCurrentAlarmState(boolean active) {
        this.currentAlarmState = active;
    }

    public String getReminderTitle() {
        return alarmTitle.getText().toString();
    }
    public String getReminderMessage() {
        return alarmMessage.getText().toString();
    }

    @Override
    public void startAlarmListActivity() {
        //TODO: do I need to null check activity before calling this?

        //Is there an edge case, where Activity may be null, when this
        //method is called?
        Intent i = new Intent(getActivity(), AlarmListActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    @Override
    public void setUpDropDown(List<Reason> reasons) {
        dropDownHeaderTitle.setText("");
        viewActions = new DropDownAdapter.ViewActions() {
            @Override
            public void collapseDropDown() {
                dropDownView.collapseDropDown();
            }

            @Override
            public void setSelectedStand(int standId) {
                if (!TextUtils.isEmpty(alarmMessage.getText()))
                    alarmMessage.setText(alarmMessage.getText() + ".\n" + getStandTitle(standId));
                else
                    alarmMessage.setText(getStandTitle(standId));
                selectedStandId = standId;
            }

            @Override
            public String getStandTitle(int standId) {
                return reasons.get(standId).getReasonMessage();
            }

            @Override
            public int getSelectedStand() {
                return selectedStandId;
            }
        };
        adapter = new DropDownAdapter(viewActions, reasons.size());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showNotification() {
        Intent intent = AlarmListActivity.getIntentForNotification(getActivity());
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),
                REQUEST_CODE,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getResources().getString(R.string.notification_title))
                .setAutoCancel(true)
                .setColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary))
                .setGroup(NOTIFICATION_GROUP_KEY)
                .setGroupSummary(true)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getActivity());
        notificationManager.notify((int) SystemClock.currentThreadTimeMillis(), builder.build());
    }

    @Override
    public String getAlarmId() {
        return this.alarmId;
    }

    public boolean getVibrateOnly() {
        return vibrateOnly.isChecked();
    }

    public boolean getRenewAutomatically() {
        return autoRenew.isChecked();
    }

    public int getPickerHour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return nosePicker.getHour();
        } else {
            return nosePicker.getCurrentHour();
        }
    }

    public int getPickerMinute() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return nosePicker.getMinute();
        } else {
            return nosePicker.getCurrentMinute();
        }
    }

    public boolean getCurrentAlarmState() {
        return currentAlarmState;
    }

    @Override
    public void makeToast(int message) {
        Toast.makeText(getActivity(),
                message,
                Toast.LENGTH_SHORT)
                .show();
    }
}
