package com.example.smarttvremote.Settings;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class ScreenSettingsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });

    }


}
