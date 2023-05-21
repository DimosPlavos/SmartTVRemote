package com.example.smarttvremote.Smart_Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.smarttvremote.Basic_Main.BasicActivity;
import com.example.smarttvremote.R;

import com.example.smarttvremote.Settings.SettingsActivity;
import com.example.smarttvremote.tvapi.ITVControler;
import com.example.smarttvremote.Logcat.LogcatTVControler;
import com.example.smarttvremote.utils.Utills;

public class SmartActivity extends AppCompatActivity implements SelectListener
{
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    private final ITVControler tv = new LogcatTVControler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv.connect();

        //edw kanw methodo onClick gia to Guide Button
        Utills.SetUpViewOnClickListener(this, R.id.guide, ()->{ Toast.makeText(getApplicationContext(),"Guide button has been clicked",Toast.LENGTH_LONG).show(); });

        //edw kanv methodo onClick gia to power Button
        Utills.SetUpViewOnClickListener(this, R.id.powerbutton, ()->{ tv.powerUp(); });

        //edw kanw methodo onClick gia Channel Up and down
        Utills.SetUpViewOnClickListener(this, R.id.channelup, ()->{ tv.nextChannel(); });
        Utills.SetUpViewOnClickListener(this, R.id.channeldown, ()->{ tv.previousChannel(); });

        //edw kanw methodo onClick gia Volume Up and down
        Utills.SetUpViewOnClickListener(this, R.id.volumeup, ()->{ tv.soundUp(); });
        Utills.SetUpViewOnClickListener(this, R.id.volumedown, ()->{ tv.soundDown(); });

        //edw kanw methodo onclick gia mute
        Utills.SetUpViewOnClickListener(this, R.id.mutebutton, ()->{ tv.mute(); });

        //edw kanv methodo gia settings
        Utills.SetUpViewOnClickListener(this, R.id.settings, ()->{
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

        Utills.SetUpViewOnClickListener(this, R.id.basic, () ->{
            Intent intent = new Intent(this, BasicActivity.class);
            startActivity(intent);
        });

        recyclerviewCategory();
    }

    private void recyclerviewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerview);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Youtube", "youtube"));
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