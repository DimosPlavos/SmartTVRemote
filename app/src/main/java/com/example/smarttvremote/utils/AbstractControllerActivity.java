package com.example.smarttvremote.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.Logcat.LogcatTVControler;
import com.example.smarttvremote.tvapi.ITVControler;

public abstract class AbstractControllerActivity extends AppCompatActivity
{
    public abstract void SetUp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetUp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, LogcatTVControler.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        bouded = false;
    }

    protected ITVControler tv;
    private boolean bouded = false;
    private ServiceConnection connection = new ServiceConnection() {
        // Called when the connection with the service is established.
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Because we have bound to an explicit
            // service that is running in our own process, we can
            // cast its IBinder to a concrete class and directly access it.

            LogcatTVControler.TVControllerBinder binder = (LogcatTVControler.TVControllerBinder) service;
            //EmulatorTVControler.TVControllerBinder binder = (EmulatorTVControler.TVControllerBinder) service;

            tv = binder.getService();
            bouded = true;
        }

        // Called when the connection with the service disconnects unexpectedly.
        public void onServiceDisconnected(ComponentName className) {
            bouded = false;
        }
    };

}
