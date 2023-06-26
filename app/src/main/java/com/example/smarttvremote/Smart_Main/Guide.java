package com.example.smarttvremote.Smart_Main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.Settings.InfoActivity;
import com.example.smarttvremote.Settings.ScreenSettingsActivity;
import com.example.smarttvremote.Settings.WifiList;
import com.example.smarttvremote.utils.Utills;

public class Guide extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        Utills.SetUpViewOnClickListener(this, R.id.arrowdown, ()->{ Toast.makeText(getApplicationContext(),"Arrow down", Toast.LENGTH_LONG).show();  });
        Utills.SetUpViewOnClickListener(this, R.id.arrowup, ()->{ Toast.makeText(getApplicationContext(),"Arrow up", Toast.LENGTH_LONG).show();  });
        Utills.SetUpViewOnClickListener(this, R.id.arrowleft, ()->{ Toast.makeText(getApplicationContext(),"Arrow left", Toast.LENGTH_LONG).show();  });
        Utills.SetUpViewOnClickListener(this, R.id.arrowright, ()->{ Toast.makeText(getApplicationContext(),"Arrow right", Toast.LENGTH_LONG).show();  });
        Utills.SetUpViewOnClickListener(this, R.id.back2, ()->{ super.finish(); });
        Utills.SetUpViewOnClickListener(this, R.id.okbutton, ()->{ Toast.makeText(getApplicationContext(),"OK", Toast.LENGTH_LONG).show(); });
        Utills.SetUpViewOnClickListener(this, R.id.dayafter, ()->{ Toast.makeText(getApplicationContext(),"1 Day After", Toast.LENGTH_LONG).show();  });
        Utills.SetUpViewOnClickListener(this, R.id.daybefore, ()->{ Toast.makeText(getApplicationContext(),"1 Day Before", Toast.LENGTH_LONG).show();  });

    }
}

