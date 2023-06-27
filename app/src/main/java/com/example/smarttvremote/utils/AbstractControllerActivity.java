package com.example.smarttvremote.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.Logcat.LogcatTVControler;
import com.example.smarttvremote.tvapi.ITVControler;

import java.util.ArrayList;

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

    protected void OnVoiceRecognition()
    {
        int REQUEST_SPEECH_RECOGNIZER = 3000;
        Intent intent = new Intent  (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Operation");
        startActivityForResult(intent, REQUEST_SPEECH_RECOGNIZER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {
        int REQUEST_SPEECH_RECOGNIZER = 3000;
        super.onActivityResult(requestCode, resultCode, data);
        //Log.i("DEMO-REQUESTCODE", Integer.toString(requestCode));
        //Log.i("DEMO-RESULTCODE", Integer.toString(resultCode));

        if (requestCode == REQUEST_SPEECH_RECOGNIZER && resultCode == Activity.RESULT_OK && data != null) {
            ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String mAnswer = text.get(0);
            Log.i("DEMO-ANSWER", text.get(0));

            hundleAnswer(mAnswer.toLowerCase());
        }
        else {
            Log.e("DEMO-ERROR", "Recognizer API error");
        }
    }

    public void hundleAnswer(String answer)
    {
        switch (answer)
        {
            case "turn on":
                if(!tv.isOn()) tv.powerUp();
                break;
            case "turn off":
                if(tv.isOn()) tv.powerUp();
                break;
            case "next":
                tv.nextChannel();
                break;
            case "previous":
                tv.previousChannel();
                break;
            case "volume up":
                tv.soundUp();
                break;
            case "volume down":
                tv.soundDown();
                break;
            case "mute":
                if(!tv.isOnMute()) tv.mute();
                break;
            case "unmute":
                if(tv.isOnMute()) tv.mute();
                break;
            default:
                Toast.makeText(getApplicationContext(),"Operation is not valid",Toast.LENGTH_LONG).show();
                break;
        }
    }

}
