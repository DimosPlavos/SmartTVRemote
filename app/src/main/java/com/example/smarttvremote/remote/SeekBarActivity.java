package com.example.smarttvremote.remote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.smarttvremote.R;

public class SeekBarActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    //private ActivitySeekBarBinding binding;
    SeekBar seekBarBright;
    TextView textViewBright;

    SeekBar seekBarContrast;
    TextView textViewContrast;

    SeekBar seekBarColor;
    TextView textViewColor;

    SeekBar seekBarSaturation;
    TextView textViewSaturation;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.screen);
        seekBarBright = (SeekBar) findViewById(R.id.seekBar2);
        textViewBright = (TextView) findViewById(R.id.editTextBrightness);

        seekBarContrast = (SeekBar) findViewById(R.id.seekBar3);
        textViewContrast = (TextView) findViewById(R.id.editTextContrast);

        seekBarColor = (SeekBar) findViewById(R.id.seekBar4);
        textViewColor = (TextView) findViewById(R.id.editTextColor);

        seekBarSaturation = (SeekBar) findViewById(R.id.seekBar5);
        textViewSaturation = (TextView) findViewById(R.id.editTextSaturation);




        seekBarBright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar Bar, int progress, boolean b) {
                textViewBright.setText("Φωτεινότητα "+String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarContrast.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int contrast, boolean b) {
                textViewContrast.setText("Αντίθεση "+String.valueOf(contrast));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int color, boolean b) {
                textViewColor.setText("Χρώμα "+String.valueOf(color));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarSaturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int saturation, boolean b) {
                textViewSaturation.setText("Κορεσμός "+String.valueOf(saturation));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

}