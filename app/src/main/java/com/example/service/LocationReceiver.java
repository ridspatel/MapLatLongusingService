package com.example.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocationReceiver extends BroadcastReceiver {

    public static boolean STARTED = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        LocationReceiver.STARTED = true;
        this.doProcess(context);
    }

    public void doProcess(Context context) {

        Intent intent;
        try {
            intent = new Intent(context, LocationService.class);
            context.startService(intent);
        } catch (Exception e) {
            System.out.println(this.getClass() + " :: onReceive() :: " + e);
            e.printStackTrace();
        }
    }

}
