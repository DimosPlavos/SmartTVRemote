package com.example.smarttvremote.Settings;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smarttvremote.R;
import com.example.smarttvremote.utils.Utills;

public class ScreenSettingsActivity extends AppCompatActivity
{
    SeekBar brightness;
    TextView brightness_text;

    SeekBar contrast;
    TextView contrast_text;

    SeekBar color;
    TextView color_text;

    SeekBar saturation;
    TextView saturation_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);

        Utills.SetUpViewOnClickListener(this, R.id.back, ()->{ super.finish(); });

        brightness = findViewById(R.id.seekBar2);
        brightness_text = findViewById(R.id.editTextBrightness);

        contrast = findViewById(R.id.seekBar3);
        contrast_text = findViewById(R.id.editTextContrast);

        color = findViewById(R.id.seekBar4);
        color_text = findViewById(R.id.editTextColor);

        saturation = findViewById(R.id.seekBar5);
        saturation_text = findViewById(R.id.editTextSaturation);

        brightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                brightness_text.setText("Φωτεινότητα " + Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        contrast.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                contrast_text.setText("Αντίθεση " + Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        color.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                color_text.setText("Χρώμα " + Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        saturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                saturation_text.setText("Κορεσμός " + Integer.toString(i));
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
