package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String tag = "Event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "OnCreate....");

    }

    @Override
     protected void onStart(){
        super.onStart();
        Log.d(tag, "OnStart....");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "OnRestart....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "OnPause....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "OnStop....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "OnDestroy....");
    }

}
