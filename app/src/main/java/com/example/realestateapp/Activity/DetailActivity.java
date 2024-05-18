
package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityDetailBinding;
import com.example.realestateapp.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {
    private ConstraintLayout addBtn;
    ActivityDetailBinding binding;
    private PropertyDomain object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getBundles();
        Booking();
        setVariable();
    }
    private void Booking(){
        binding.addBtn.setOnClickListener(v -> startActivity(new Intent(DetailActivity.this,BookActivity.class)));
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
        int drawableResourceID = getResources().getIdentifier(object.getPicPath(),"drawable",DetailActivity.this.getPackageName());

        Glide.with(DetailActivity.this)
                .load(drawableResourceID)
                .into(binding.picDetail);

        binding.titleTxt.setText(object.getTitle());
        binding.typeTxt.setText(object.getType());
        binding.addressTxt.setText(object.getAddress());
        binding.descriptionTxt.setText(object.getDescription());
        binding.scoreTxt.setText(""+object.getScore());
        binding.priceTxt.setText("$"+object.getPrice());
        binding.bedTxt.setText(object.getBed()+" Bed");
        binding.bathTxt.setText(object.getBath()+"Bath");

        if(object.isWifi()){
            binding.wifiTxt.setText("Wifi");
        }else{
            binding.wifiTxt.setText("No Wifi");
        }

    }

    private void getBundles() {
        object = (PropertyDomain) getIntent().getSerializableExtra("object");
    }

}