package com.example.smarttvremote.Smart_Main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smarttvremote.Basic_Main.BasicActivity;
import com.example.smarttvremote.R;
import com.example.smarttvremote.Settings.SettingsActivity;

import java.util.ArrayList;

public class AppsAdaptor extends RecyclerView.Adapter<AppsAdaptor.ViewHolder> {
    ArrayList<AppsDomain> appDomains;
    private SelectListener listener;

    public AppsAdaptor(ArrayList<AppsDomain> appDomains, SelectListener listener){
        this.appDomains = appDomains;
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category_apps,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsAdaptor.ViewHolder holder, int position) {
        holder.AppName.setText(appDomains.get(position).getTitle());
        String picUrl = "";
        switch (position) {
            case 0: {
                picUrl = "youtube";
                holder.mainLayoutApp.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }case 1: {
                picUrl = "spotify";
                holder.mainLayoutApp.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }case 2: {
                picUrl = "netflix";
                holder.mainLayoutApp.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
            case 3: {
                picUrl = "googleapp";
                holder.mainLayoutApp.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.cat_background));
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.AppPic);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClickedApps(appDomains.get(position));
            }


        });
    }

    @Override
    public int getItemCount() {
        return appDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView AppName;
        ImageView AppPic;
        ConstraintLayout mainLayoutApp;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            AppName = itemView.findViewById(R.id.AppName);
            AppPic = itemView.findViewById(R.id.AppPic);
            mainLayoutApp = itemView.findViewById(R.id.mainLayoutApp);
        }
    }
}
