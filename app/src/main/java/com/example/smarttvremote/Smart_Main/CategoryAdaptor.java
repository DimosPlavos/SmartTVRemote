package com.example.smarttvremote.Smart_Main;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.smarttvremote.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;
    private SelectListener listener;

    public CategoryAdaptor(ArrayList<CategoryDomain> categoryDomains, SelectListener listener){
        this.categoryDomains = categoryDomains;
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdaptor.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "mega_playingnow";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }case 1: {
                picUrl = "netflix";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }case 2: {
                picUrl = "mute";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }case 3: {
                picUrl = "plus";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(categoryDomains.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

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
            Log.i("TV", "HAHAHAHAH");

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

               // int seekBarValue = 10;
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   // seekBarValue = progress;
                    textViewBright.setText("Android: "+progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
//            seekBarContrast.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//                @Override
//                public void onProgressChanged(SeekBar seekBar, int contrast, boolean b) {
//                    textViewContrast.setText("Αντίθεση "+String.valueOf(contrast));
//
//                }
//
//                @Override
//                public void onStartTrackingTouch(SeekBar seekBar) {
//
//                }
//
//                @Override
//                public void onStopTrackingTouch(SeekBar seekBar) {
//
//                }
//            });
//            seekBarColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//                @Override
//                public void onProgressChanged(SeekBar seekBar, int color, boolean b) {
//                    textViewColor.setText("Χρώμα "+String.valueOf(color));
//
//                }
//
//                @Override
//                public void onStartTrackingTouch(SeekBar seekBar) {
//
//                }
//
//                @Override
//                public void onStopTrackingTouch(SeekBar seekBar) {
//
//                }
//            });
//            seekBarSaturation.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//                @Override
//                public void onProgressChanged(SeekBar seekBar, int saturation, boolean b) {
//                    textViewSaturation.setText("Κορεσμός "+String.valueOf(saturation));
//
//                }
//
//                @Override
//                public void onStartTrackingTouch(SeekBar seekBar) {
//
//                }
//
//                @Override
//                public void onStopTrackingTouch(SeekBar seekBar) {
//
//                }
//            });



        }

    }
}
