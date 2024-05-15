
package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private ConstraintLayout addBtn;
    ActivityDetailBinding binding;
    private PropertyDomain object;
    private final List<PropertyDomain> favoriteList = new ArrayList<PropertyDomain>();
    private final String item = "YourItem"; // Thay thế bằng item thực tế bạn muốn thêm vào danh sách
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getBundles();
        setVariable();
        Booking();
        setupToggleButton();
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
    private void setupToggleButton() {
        ToggleButton toggleButton = findViewById(R.id.mytoggle);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Thêm mục vào danh sách yêu thích
                if (!favoriteList.contains(object)) {
                    favoriteList.add(object);
                }
            } else {
                // Xóa mục khỏi danh sách yêu thích
                favoriteList.remove(object);
            }
        });
    }

}