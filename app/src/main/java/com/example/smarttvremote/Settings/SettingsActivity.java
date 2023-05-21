package com.example.smarttvremote.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class SettingsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });

        Utills.SetUpViewOnClickListener(this, R.id.sett_screen, ()->{
            Intent intent = new Intent(this, ScreenSettingsActivity.class);
            startActivity(intent);
        });


    }
}
