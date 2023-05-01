package com.example.smarttvremote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.smarttvremote.CategoryAdaptor;
import com.example.smarttvremote.CategoryDomain;

import com.example.smarttvremote.R;

public class MainActivity extends AppCompatActivity implements SelectListener {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;

    Button guidebtn, sourcebtn, appsbtn;
    ImageView channelupbtn, channeldownbtn, powerbtn, volumeupbtn, volumedownbtn, mutebtn, returnbtn, micbtn, settingsbtn, modebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //edw kanw methodo onClick gia to Guide Button
        guidebtn = findViewById(R.id.guide);
        guidebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Guide button has been clicked",Toast.LENGTH_LONG).show();
            }
        });

        //edw kanw methodo onClick gia thn image Channel Up
        channelupbtn = findViewById(R.id.channelup);
        channelupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Channel 1 up",Toast.LENGTH_LONG).show();
            }
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