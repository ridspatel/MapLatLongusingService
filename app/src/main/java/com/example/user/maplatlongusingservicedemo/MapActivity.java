package com.example.user.maplatlongusingservicedemo;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.service.ServiceManager;
import com.example.utils.Config;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity {

    private GoogleMap map;

    double latitude;
    double longitude;

    private Location loc;
    private LocationManager LC;
    private UiSettings setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /** start service */
        Config.serviceManager = new ServiceManager();

        initilizeMap();

    }

    private void initilizeMap() {

        // Getting reference to SupportMapFragment of the activity_main
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Getting Map for the SupportMapFragment
        map = fm.getMap();

        map.setMyLocationEnabled(true);

        // Set Map Type
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Call getCurrentLocation()
        getCurrentLocation();

        // Create Marker for Current Location
        MarkerOptions currentLocMarker = new MarkerOptions()
                .position(new LatLng(latitude, longitude));
        map.addMarker(currentLocMarker); // Adding Marker

        // Moving Camera to a Location with animation
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(15).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        // check if map is created successfully or not
        if (map == null) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
        }
        /* to remove inbuilt current location & zoom control from map */
        setting = map.getUiSettings();
        setting.setZoomControlsEnabled(false);
        // setting.setMyLocationButtonEnabled(false);
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return true;
            }
        });
    }

    // Get Current Location
    private void getCurrentLocation() {
        MapActivity.this.runOnUiThread(new Runnable() {
                                           @Override
                                           public void run() {

                                               CameraPosition cameraPosition = new CameraPosition.Builder()
                                                       .target(new LatLng(latitude, longitude)).zoom(15)
                                                       .build();
                                               map.animateCamera(CameraUpdateFactory
                                                       .newCameraPosition(cameraPosition));
//                if (map.isMyLocationEnabled() && map.getMyLocation() != null) {
//
//                    latitude = (double) map.getMyLocation().getLatitude();
//                    longitude = (double) map.getMyLocation().getLongitude();
//                } else {
                                               LC = (LocationManager) getSystemService(MapActivity.LOCATION_SERVICE);

                                               loc = LC.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                                               if (loc != null) {
                                                   latitude = (double) loc.getLatitude();
                                                   longitude = (double) loc.getLongitude();
                                               } else {
                                                   loc = LC.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                                                   if (loc != null) {
                                                       latitude = (double) loc.getLatitude();
                                                       longitude = (double) loc.getLongitude();

                                                   }
                                               }
                                           }
                                       }

        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        System.out.println("----------onResume ------ ");

        /** to fetch location every 5 seconds */
        Config.serviceManager.startLocationReceiver(this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        System.out.println("----------onPause ------ ");

        /** to fetch location every 5 seconds */
        Config.serviceManager.stopLocationReceiver();

    }
}
