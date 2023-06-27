package com.example.smarttvremote.Settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class SleepTimerActivity extends AppCompatActivity
{
    private int time = 0;

    TextView text_view;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sleep_timer);

        text_view = (TextView)findViewById(R.id.time_text);
        text_view.setText(Integer.toString(time) + " Λεπτά");

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });

        Utills.SetUpViewOnClickListener(this, R.id.add_time, ()->{
            if(time < 999){
                time++;
            }
            text_view.setText(Integer.toString(time) + " Λεπτά");
        });

        Utills.SetUpViewOnClickListener(this, R.id.sub_time, ()->{
            if(time > 0){
                time--;
            }
            text_view.setText(Integer.toString(time) + " Λεπτά");
        });
    }
}
