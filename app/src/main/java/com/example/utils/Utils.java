package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class Utils {


    public static boolean isOnline(Context context) {

        try {
            if (context == null)
                return false;

            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            if (cm != null) {
                return cm.getActiveNetworkInfo().isConnected();
            } else {
                return false;
            }
        } catch (Exception e) {
//			Log.error(context.getClass() + " :: isonline() ", e);
            return false;
        }
    }


}