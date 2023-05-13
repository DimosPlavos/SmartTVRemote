package com.example.smarttvremote.remote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.smarttvremote.R;

import com.example.smarttvremote.tvapi.ITVControler;
import com.example.smarttvremote.Logcat.LogcatTVControler;

public class MainActivity extends AppCompatActivity implements SelectListener
{
    private interface ONClickLambda{
        void run();
    }

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    private final ITVControler tv = new LogcatTVControler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv.connect();

        //edw kanw methodo onClick gia to Guide Button
        SetUpViewOnClickListener(R.id.guide, ()->{ Toast.makeText(getApplicationContext(),"Guide button has been clicked",Toast.LENGTH_LONG).show(); });

        //edw kanv methodo onClick gia to power Button
        SetUpViewOnClickListener(R.id.powerbutton, ()->{ tv.powerUp(); });

        //edw kanw methodo onClick gia Channel Up and down
        SetUpViewOnClickListener(R.id.channelup, ()->{ tv.nextChannel(); });
        SetUpViewOnClickListener(R.id.channeldown, ()->{ tv.previousChannel(); });

        //edw kanw methodo onClick gia Volume Up and down
        SetUpViewOnClickListener(R.id.volumeup, ()->{ tv.soundUp(); });
        SetUpViewOnClickListener(R.id.volumedown, ()->{ tv.soundDown(); });

        //edw kanw methodo onclick gia mute
        SetUpViewOnClickListener(R.id.mutebutton, ()->{ tv.mute(); });

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

    private void SetUpViewOnClickListener(int view_id,  ONClickLambda onclick)
    {
        findViewById(view_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onclick.run();
            }
        });
    }
}