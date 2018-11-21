package com.rocklobstre.parrot.data.local.realmmodel;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * POJO for Realm
 * Created by Matin on 10/04/2016.
 */
@RealmClass
public class RealmAlarm implements RealmModel {

    @PrimaryKey
    private String alarmId;

    private String alarmTitle;
    private String alarmMessage;
    private boolean active;
    private boolean vibrateOnly;
    private boolean renewAutomatically;
    private int hourOfDay;
    private int minute;
    private int volume;

    public RealmAlarm() {
        //blank constructor for realm?
    }

    public RealmAlarm(String alarmId,
                      String alarmTitle,
                      String alarmMessage,
                      boolean active,
                      boolean vibrateOnly,
                      boolean renewAutomatically,
                      int minute,
                      int hourOfDay,
                      int volume
    ) {

        this.alarmId = alarmId;
        this.alarmTitle = alarmTitle;
        this.alarmMessage = alarmMessage;
        this.active = active;
        this.vibrateOnly = vibrateOnly;
        this.renewAutomatically = renewAutomatically;
        this.minute = minute;
        this.hourOfDay = hourOfDay;
        this.volume = volume;
    }

    /**
     * To create a new RealmAlarm
     *
     * @param alarmId
     */
    public RealmAlarm(String alarmId) {
        this.alarmId = alarmId;
        this.hourOfDay = 12;
        this.minute = 0;
        this.alarmTitle = "New Alarm";
        this.alarmMessage = "You have set an alarm, do you remember why?";
        this.active = false;
        this.vibrateOnly = false;
        this.renewAutomatically = false;
        this.volume = 70;

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmTitle() {
        return alarmTitle;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isVibrateOnly() {
        return vibrateOnly;
    }

    public void setVibrateOnly(boolean vibrateOnly) {
        this.vibrateOnly = vibrateOnly;
    }

    public boolean isRenewAutomatically() {
        return renewAutomatically;
    }

    public void setRenewAutomatically(boolean renewAutomatically) {
        this.renewAutomatically = renewAutomatically;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }


}
