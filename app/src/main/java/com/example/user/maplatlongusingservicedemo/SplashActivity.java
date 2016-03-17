package com.example.user.maplatlongusingservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends Activity {
    private Button btnSingleServiceClass, btnServiceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnSingleServiceClass = (Button) findViewById(R.id.btnSingleServiceClass);
        btnServiceManager = (Button) findViewById(R.id.btnServiceManager);

        btnSingleServiceClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(SplashActivity.this, SingleActivity.class);
                startActivity(i1);
            }
        });

        btnServiceManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(SplashActivity.this, MapActivity.class);
                startActivity(i2);
            }
        });


    }
}
