package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;

import com.example.utils.Config;


public class LocationService extends Service {

    public String title = null;
    public Location loc = null;
    public LocationManager locationManager = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @SuppressWarnings({"deprecation", "static-access"})
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        if (this.locationManager == null) {
            this.locationManager = (LocationManager) getSystemService(this.LOCATION_SERVICE);
        }

        /**
         * get longitude & latitude every 5 seconds
         */
        System.out.println("----------------- LocationReceiver.STARTED :::::::" + LocationReceiver.STARTED);
        if (LocationReceiver.STARTED) {
            this.getCurrentLocation();

            System.out.println("----------LocationService ------ lat ::: "
                    + Config.LATITUDE);
            System.out.println("----------LocationService ------ long ::: "
                    + Config.LONGITUDE);
        }
    }

    /**
     * Get current Location from location Listener.
     */
    private void getCurrentLocation() {

        loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        Config.IS_LOCATION_AVAILABLE = false;
        if (loc != null) {
            Config.LATITUDE = (double) loc.getLatitude();
            Config.LONGITUDE = (double) loc.getLongitude();
            Config.IS_LOCATION_AVAILABLE = true;
        } else {
            loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (loc != null) {
                Config.LATITUDE = (double) loc.getLatitude();
                Config.LONGITUDE = (double) loc.getLongitude();
                Config.IS_LOCATION_AVAILABLE = true;
            }
        }
    }
}