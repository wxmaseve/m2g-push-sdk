package com.sk.m2gdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.sk.m2g.M2gPush;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("dev", "request start");
        M2gPush.registerToken("8f51a5aa-9ec0-418e-8879-d89ce0b3bc4d");
    }
}