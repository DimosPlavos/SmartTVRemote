package com.example.smarttvremote.utils;

import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Utills
{
    public interface OnClickLambda{
        void run();
    }

    public interface OnTouchLambda{
        void run(View v, MotionEvent event);
    }

    public static void SetUpViewOnClickListener(AppCompatActivity activity, int view_id,  Utills.OnClickLambda onclick)
    {
        activity.findViewById(view_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.run();
            }
        });
    }

    public static void SetUpOnTouchListener(AppCompatActivity activity, int view_id, Utills.OnTouchLambda ontouch)
    {
        activity.findViewById(view_id).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ontouch.run(view, motionEvent);

                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    view.performClick();
                }
                return true;
            }
        });
    }
}
