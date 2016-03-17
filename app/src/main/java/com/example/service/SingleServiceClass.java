package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.utils.Config;

import java.util.Timer;
import java.util.TimerTask;


public class SingleServiceClass extends Service {

    private Timer timer;
    public String title = null;
    public Location loc = null;
    public LocationManager locationManager = null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        System.out.println("----------------- START SERVICE:::::::");

        if (this.locationManager == null) {
            this.locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        }

         /* get longitude&latitude every 5 seconds */
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getCurrentLocation();

                System.out.println("----------SingleServiceClass::::LocationService ------ lat ::: "
                        + Config.LATITUDE);
                System.out.println("----------SingleServiceClass::::LocationService ------ long ::: "
                        + Config.LONGITUDE);
            }
        }, 3000, 3000);


    }


    private void getCurrentLocation() {

        loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (loc != null) {
            Config.LATITUDE = (double) loc.getLatitude();
            Config.LONGITUDE = (double) loc.getLongitude();
        } else {
            loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (loc != null) {
                Config.LATITUDE = (double) loc.getLatitude();
                Config.LONGITUDE = (double) loc.getLongitude();
            }
        }
    }

    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}
