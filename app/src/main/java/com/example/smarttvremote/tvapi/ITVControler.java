package com.example.smarttvremote.tvapi;

public interface ITVControler
{
    // connect with the tv
    void connect();
    // disconnect with the tv
    void disconnect();
    // push the power button
    void powerUp();

    // sound
    void mute(); // for the mute button
    void soundUp(); // increase the sound
    void soundDown(); // decrease the sound

    // channels
    void nextChannel(); // goes to the next Channel
    void previousChannel(); // goes to the previous Channel
    void goToChannel(int num); // goes to the channel with number <num>
}
