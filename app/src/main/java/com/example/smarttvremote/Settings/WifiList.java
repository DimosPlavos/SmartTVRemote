package com.example.smarttvremote.Settings;

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
    }
}
