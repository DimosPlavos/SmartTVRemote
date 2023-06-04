package com.example.smarttvremote.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class WifiList extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wifi_list);

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });
        Utills.SetUpViewOnClickListener(this, R.id.sett_Wifi1, ()->{
            Intent intent = new Intent(this, WifiActivity.class);
            startActivity(intent);
        });
        Utills.SetUpViewOnClickListener(this, R.id.sett_Wifi2, ()->{
            Intent intent = new Intent(this, WifiActivity.class);
            startActivity(intent);
        });
        Utills.SetUpViewOnClickListener(this, R.id.sett_Wifi3, ()->{
            Intent intent = new Intent(this, WifiActivity.class);
            startActivity(intent);
        });
        Utills.SetUpViewOnClickListener(this, R.id.sett_Wifi4, ()->{
            Intent intent = new Intent(this, WifiActivity.class);
            startActivity(intent);
        });
    }
}
