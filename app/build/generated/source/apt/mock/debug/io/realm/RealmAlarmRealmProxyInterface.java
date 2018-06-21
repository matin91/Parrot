package io.realm;


public interface RealmAlarmRealmProxyInterface {
    public String realmGet$alarmId();
    public void realmSet$alarmId(String value);
    public String realmGet$alarmTitle();
    public void realmSet$alarmTitle(String value);
    public String realmGet$alarmMessage();
    public void realmSet$alarmMessage(String value);
    public boolean realmGet$active();
    public void realmSet$active(boolean value);
    public boolean realmGet$vibrateOnly();
    public void realmSet$vibrateOnly(boolean value);
    public boolean realmGet$renewAutomatically();
    public void realmSet$renewAutomatically(boolean value);
    public int realmGet$hourOfDay();
    public void realmSet$hourOfDay(int value);
    public int realmGet$minute();
    public void realmSet$minute(int value);
}
