package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.realestateapp.Adapter.NearbyAdapter;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityMainBinding;
import com.example.realestateapp.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    ActivitySearchBinding binding;
    private RecyclerView.Adapter adapterRecommended,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchView();
    }

    private void searchView() {

        Intent intent = getIntent();
        ArrayList<PropertyDomain> tmp = (ArrayList<PropertyDomain>) intent.getSerializableExtra("dataList");

        binding.searchView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterNearby = new NearbyAdapter(tmp);
        binding.searchView.setAdapter(adapterNearby);

    }
}