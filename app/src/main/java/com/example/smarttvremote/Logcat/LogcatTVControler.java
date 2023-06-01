package com.example.smarttvremote.Logcat;
import com.example.smarttvremote.tvapi.ITVControler;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

// logs messages in the Logcat console (go to view -> Tool Windows -> Logcat)
public class LogcatTVControler extends Service implements ITVControler
{
    private boolean TVisOn = false; // is the tv on or off?

    private boolean TVinMute = false; // the tv mute or not
    private int volume = 50; // the sound volume

    private int NumOfChannels = 10;
    private int currentChannel = 1;

    @Override
    public void connect()
    {
        Log.i("TV", "The TV has connected with the remote");
    }

    @Override
    public void disconnect() {
        Log.i("TV", "The TV has disconnected with the remote");
    }

    @Override
    public void powerUp() {
        if(this.TVisOn)
        {
            Log.i("TV", "The TV has Turned OFF");
            this.TVisOn = false;
        }
        else {
            Log.i("TV", "The TV has Turned ON");
            this.TVisOn = true;
        }
    }

    @Override
    public boolean isOn() {
        return TVisOn;
    }

    @Override
    public void mute() {
        if(!this.TVisOn)
        {
            return;
        }

        if(this.TVinMute)
        {
            // unmute
            Log.i("TV", "The TV has Turned the Sound ON");
            this.TVinMute = false;
        }
        else {
            // mute
            Log.i("TV", "The TV has Turned the Sound OFF");
            this.TVinMute = true;
        }
    }

    @Override
    public void soundUp() {
        if(this.TVisOn)
        {
            this.TVinMute = false;
            if(this.volume == 100) return;
            this.volume = (this.volume + 1) % (100 + 1);

            Log.i("TV", String.format("The volume is at %d", this.volume));
        }
    }

    @Override
    public void soundDown() {
        if(this.TVisOn)
        {
            this.TVinMute = false;
            this.volume = (this.volume - 1) % (100 + 1);
            if(this.volume <= 0) { this.volume = 0; }

            Log.i("TV", String.format("The volume is at %d", this.volume));
        }
    }

    @Override
    public void nextChannel() {
        if(this.TVisOn)
        {
            this.currentChannel = (this.currentChannel + 1) % (this.NumOfChannels + 1);
            if(this.currentChannel <= 0) { this.currentChannel = 1; }

            Log.i("TV", String.format("We are watching channel %d", this.currentChannel));
        }
    }

    @Override
    public void previousChannel() {
        if(this.TVisOn)
        {
            if(this.currentChannel == 1) { this.currentChannel = this.NumOfChannels; return; }
            this.currentChannel = (this.currentChannel - 1) % (this.NumOfChannels + 1);

            Log.i("TV", String.format("We are watching channel %d", this.currentChannel));
        }
    }

    @Override
    public void goToChannel(int num) {
        this.currentChannel = num;
    }


    private final TVControllerBinder binder = new TVControllerBinder();
    private boolean bonded = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        if(!bonded)
        {
            this.connect();
            bonded = true;
        }

        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        this.disconnect();
        return false;
    }

    public class TVControllerBinder extends Binder
    {
        public ITVControler getService() {
            return LogcatTVControler.this;
        }
    }

}
