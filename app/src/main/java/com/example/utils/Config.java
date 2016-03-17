package com.example.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import com.example.service.ServiceManager;

import java.util.ArrayList;

public class Config {

    public static String TAG = "MapTracks";
    // Create a directory in SD CARD
    public static String APP_HOME = Environment.getExternalStorageDirectory()
            .getPath() + "/" + TAG;

    // A directory to store logs
    public static String DIR_LOG = APP_HOME + "/log";
    // preference file name
    public static final String PREF_FILE = TAG + "_PREF";

    // A directory to store logs
    public static String DB_NAME = "Tracks.db";
    // public static String DB_NAME = APP_HOME + "/Tracks.db";

    // preference file name
    public static final String DIR_USER = APP_HOME + "/user";
    /* API */
    public static String API_KEY = "TRACKS2014";
    public static String API_VERSION = "1.0";

    public static String HOST = "http://tracker.esprit-apps.com/api";
    public static String HOST_URL = "http://tracker.esprit-apps.com/";
    public static String DIR_USERDATA = HOST_URL + "/userdata";

    public static String API_SIGNUP = HOST + "/signUp.php";

    // API TAGS
    // For each API we must have a TAG
    public static String TAG_SIGNUP = "API_SIGNUP";

    /*
     * Error and Warnings
     */
    public static String ERROR_NETWORK = "ERROR_NETWORK";
    public static String ERROR_API = "ERROR_API";
    public static String ERROR_UNKNOWN = "ERROR_UNKNOWN";

    public static int API_SUCCESS = 0;
    public static int API_FAIL = 1;

    // connection timeout is set to 20 seconds
    public static int TIMEOUT_CONNECTION = 30000;

    // SOCKET TIMEOUT IS SET TO 30 SECONDS
    public static int TIMEOUT_SOCKET = 30000;

    /*
     * Cookie and SESSION
     */
    public static String PREF_SESSION_COOKIE = "sessionid";
    public static String SET_COOKIE_KEY = "Set-Cookie";
    public static String COOKIE_KEY = "Cookie";
    public static String SESSION_COOKIE = "sessionid";


    /* for location */
    public static Boolean IS_LOCATION_AVAILABLE = false;
    public static double LATITUDE = 0;
    public static double LONGITUDE = 0;


    // public static String PREF_UPDATE_LOCATION_FREQUENCY = null;
    // public static String FILE_LOCATION_URL =
    // "www.google.com/chart?chst=d_map_pin_letter&chld=|";
    public static String FILE_LOCATION_URL = "chart.apis.google.com/chart?chst=d_map_spin&chld=0.8|0|";
    public static String FILE_PICTURE_URL = "chart.apis.google.com/chart?chst=d_map_spin&chld=0.8|0|";
    // FFFF42|15|b|P
    public static String FILE_VIDEO_URL = "chart.apis.google.com/chart?chst=d_map_spin&chld=0.8|0|";
    // http://FFFF42|15|b|V

    public static Context UPLOAD_FILE_CONTEXT;
    public static Context UPLOAD_LOCATION_CONTEXT;
    public static ArrayList<Activity> objActivityList;

    public static ServiceManager serviceManager = null;
    public static Boolean IS_COME_FROM_LOGIN = false;
}
