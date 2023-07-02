package com.example.smarttvremote.Smart_Main;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class MoreApps extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moreapps);

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });
    }

}