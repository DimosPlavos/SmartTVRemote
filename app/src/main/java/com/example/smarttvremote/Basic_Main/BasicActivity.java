package com.example.smarttvremote.Basic_Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.smarttvremote.R;
import com.example.smarttvremote.Settings.SettingsActivity;
import com.example.smarttvremote.Smart_Main.SmartActivity;
import com.example.smarttvremote.utils.AbstractControllerActivity;
import com.example.smarttvremote.utils.Utills;

public class BasicActivity extends AbstractControllerActivity
{
    @Override
    public void SetUp() {
        setContentView(R.layout.basic);

        Utills.SetUpViewOnClickListener(this, R.id.b_powerbutton, ()->{ tv.powerUp(); });
        Utills.SetUpViewOnClickListener(this, R.id.b_mutebutton, ()->{
            tv.mute();
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.b_button0, ()->{ handleNumbers(0); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button1, ()->{ handleNumbers(1); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button2, ()->{ handleNumbers(2); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button3, ()->{ handleNumbers(3); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button4, ()->{ handleNumbers(4); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button5, ()->{ handleNumbers(5); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button6, ()->{ handleNumbers(6); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button7, ()->{ handleNumbers(7); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button8, ()->{ handleNumbers(8); });
        Utills.SetUpViewOnClickListener(this, R.id.b_button9, ()->{ handleNumbers(9); });

        Utills.SetUpViewOnClickListener(this, R.id.b_volumeup, ()->{ tv.soundUp(); });
        Utills.SetUpViewOnClickListener(this, R.id.b_volumedown, ()->{ tv.soundDown(); });

        Utills.SetUpViewOnClickListener(this, R.id.b_channelup, ()->{ tv.nextChannel(); });
        Utills.SetUpViewOnClickListener(this, R.id.b_channeldown, ()->{ tv.previousChannel(); });

        Utills.SetUpOnTouchListener(this, R.id.b_microphone, (View v, MotionEvent event) ->
        {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    longClickHandler.postDelayed(longClickRunnable, 1000); // Start the long click handler after 2 seconds
                    v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS); // Vibrate when button is pressed
                    v.animate().scaleX(0.95f).scaleY(0.95f).setDuration(100); // Apply scaling effect
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    longClickHandler.removeCallbacks(longClickRunnable); // Cancel the long click handler
                    v.performHapticFeedback(HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING); // Cancel vibration when button is released or touch is canceled
                    v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100); // Reset scaling effect
                    break;
            }
        });

        Utills.SetUpViewOnClickListener(this, R.id.b_settings, ()->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.b_mode, () ->{
            Intent intent = new Intent(this, SmartActivity.class);
            startActivity(intent);
            UpdateUI();
        });
    }

    @Override
    public void UpdateUI() {
        ImageView button = (ImageButton)findViewById(R.id.b_mutebutton);

        if(tv.isOnMute()) {
            button.setImageResource(R.drawable.unmute1);
        }else{
            button.setImageResource(R.drawable.mute1);
        }
    }

    private void handleNumbers(int num)
    {

    }

}
