package com.example.smarttvremote.Smart_Main;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.smarttvremote.Basic_Main.BasicActivity;
import com.example.smarttvremote.R;
import com.example.smarttvremote.Settings.SettingsActivity;
import com.example.smarttvremote.Settings.SourceActivity;
import com.example.smarttvremote.utils.AbstractControllerActivity;
import com.example.smarttvremote.utils.Utills;

public class SmartActivity extends AbstractControllerActivity implements SelectListener
{
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    @Override
    public void SetUp() {
        setContentView(R.layout.smart);

        Utills.SetUpViewOnClickListener(this, R.id.s_powerbutton, ()->{ tv.powerUp(); });

        Utills.SetUpViewOnClickListener(this, R.id.source, ()->{
            Intent intent = new Intent(this, SourceActivity.class);
            startActivity(intent);
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.channelup, ()->{ tv.nextChannel(); });
        Utills.SetUpViewOnClickListener(this, R.id.channeldown, ()->{ tv.previousChannel(); });

        Utills.SetUpViewOnClickListener(this, R.id.volumeup, ()->{ tv.soundUp(); });
        Utills.SetUpViewOnClickListener(this, R.id.volumedown, ()->{ tv.soundDown(); });

        Utills.SetUpViewOnClickListener(this, R.id.guide, () ->{
            Intent intent = new Intent(this, Guide.class);
            startActivity(intent);
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.s_mutebutton, ()->{
            tv.mute();
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.settings, ()->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            UpdateUI();
        });

        Utills.SetUpViewOnClickListener(this, R.id.basic, () ->{
            super.finish();
        });

        Utills.SetUpOnTouchListener(this, R.id.microphone, (View v, MotionEvent event) ->
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

        recyclerviewCategory();
    }

    @Override
    public void UpdateUI() {
        ImageView button = (ImageView)findViewById(R.id.s_mutebutton);

        if(tv.isOnMute()) {
            button.setImageResource(R.drawable.unmute);
        }else{
            button.setImageResource(R.drawable.mute);
        }
    }

    private void recyclerviewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerview);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Mega: Eytyximenoi Mazi", "mega_playingnow"));
        category.add(new CategoryDomain("Netflix", "netflix"));
        category.add(new CategoryDomain("Mute", "mute"));
        category.add(new CategoryDomain("Plus", "plus"));

        adapter = new CategoryAdaptor(category, this);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    public void onItemClicked(CategoryDomain myModel) {
        //edw epilegei ti ginetai meta to click
        Toast.makeText(this,myModel.getTitle(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}