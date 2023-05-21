package com.example.smarttvremote.Basic_Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.Smart_Main.SmartActivity;
import com.example.smarttvremote.utils.Utills;

public class BasicActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bb);

        Utills.SetUpViewOnClickListener(this, R.id.smart, () ->{
            Intent intent = new Intent(this, SmartActivity.class);
            startActivity(intent);
        });


    }
}
