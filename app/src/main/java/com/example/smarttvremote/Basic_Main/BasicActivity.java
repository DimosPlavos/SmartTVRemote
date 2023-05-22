package com.example.smarttvremote.Basic_Main;

import android.content.Intent;
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
        Utills.SetUpViewOnClickListener(this, R.id.b_mutebutton, ()->{ tv.mute(); });

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

        Utills.SetUpViewOnClickListener(this, R.id.b_microphone, ()->{ microphone(); });

        Utills.SetUpViewOnClickListener(this, R.id.b_settings, ()->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

        Utills.SetUpViewOnClickListener(this, R.id.b_mode, () ->{
            Intent intent = new Intent(this, SmartActivity.class);
            startActivity(intent);
        });
    }

    private void handleNumbers(int num)
    {

    }

    private void microphone()
    {

    }
}
