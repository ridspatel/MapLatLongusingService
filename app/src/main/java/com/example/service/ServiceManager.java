package com.example.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class ServiceManager {
    public static PendingIntent piSR = null;
    public static AlarmManager amSR = null;
    public static PendingIntent piLR = null;
    public static AlarmManager amLR = null;
    public static PendingIntent piUR = null;
    public static AlarmManager amUR = null;
    public static PendingIntent piFR = null;
    public static AlarmManager amFR = null;

    public void startLocationReceiver(Context context) {

        if (!LocationReceiver.STARTED) {

            // Wake up Service
            amLR = (AlarmManager) context
                    .getSystemService(Context.ALARM_SERVICE);
            Intent intentLR = new Intent(context, LocationReceiver.class);
            piLR = PendingIntent.getBroadcast(context, 0, intentLR, 0);
            amLR.setRepeating(AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 5000, 5 * 1000, piLR); // 60000
        }
    }

    public void stopLocationReceiver() {
        if (amLR != null) {
            amLR.cancel(piLR);
            amLR = null;
            LocationReceiver.STARTED = false;
        }
    }
}
