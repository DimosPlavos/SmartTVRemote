package com.example.smarttvremote.utils;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Utills
{
    public interface ONClickLambda{
        void run();
    }

    public static void SetUpViewOnClickListener(AppCompatActivity activity, int view_id,  Utills.ONClickLambda onclick)
    {
        activity.findViewById(view_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.run();
            }
        });
    }
}
