package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityBookingBinding;

public class BookActivity extends AppCompatActivity {
    ActivityBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}