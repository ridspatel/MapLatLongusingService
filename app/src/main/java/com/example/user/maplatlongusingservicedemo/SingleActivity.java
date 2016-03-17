package com.example.user.maplatlongusingservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.service.SingleServiceClass;

/**
 * Created by user on 29/1/16.
 */
public class SingleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        System.out.println("----------onCreate ------ ");

        Intent i = new Intent(SingleActivity.this, SingleServiceClass.class);
        startService(i);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SingleActivity.this, SingleServiceClass.class);
        stopService(i);
        finish();
    }
}
