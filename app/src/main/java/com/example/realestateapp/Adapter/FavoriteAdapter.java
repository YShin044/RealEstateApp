package com.example.realestateapp.Adapter;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.Helper.ManageFavorite;

import java.security.AccessController;
import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder>{
private ArrayList<PropertyDomain> propertyDomain;
private ManageFavorite manageFavorite;

public FavoriteAdapter(ArrayList<PropertyDomain> PropertyDomain, Context context) {
        this.propertyDomain = propertyDomain;
        this.manageFavorite = new ManageFavorite(context);
        }

//@NonNull
//@Override
//public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
//
//        return new RecyclerView.ViewHolder(inflate);
//        }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public WindowDecorActionBar.TabImpl title;
        public AccessController itemView;
        public ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}