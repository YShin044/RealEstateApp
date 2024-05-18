package com.example.realestateapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestateapp.Adapter.NearbyAdapter;
import com.example.realestateapp.Adapter.RecommendedAdapter;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterRecommended,adapterNearby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLocation();
        initRecycleView();
        Home_Favorite();
        Home_Post();
    }
    private void Home_Favorite() {
        LinearLayout linearLayoutf = findViewById(R.id.FAVBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        linearLayoutf.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FavoriteList.class)));
        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
    private void Home_Post() {
        LinearLayout linearLayoutp = findViewById(R.id.PostBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        linearLayoutp.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Post.class)));
        homeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        });
    }
//    private void Post_Favorite() {
//        LinearLayout linearLayoutp = findViewById(R.id.FAVBtn);
//        LinearLayout PostBtn = findViewById(R.id.PostBtn);
//
//        linearLayoutp.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, FavoriteList.class)));
//        PostBtn.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
//            startActivity(intent);
//        });
//    }
    private void initRecycleView() {
        ArrayList<PropertyDomain> items = new ArrayList<>();
        items.add(new PropertyDomain("Apartment","Royal Apartment","District 1 VN","h_1",20000,3,3,true,4.5,"This 2 bed /1 bath home boast enormous, open-living room plan, accented by striking architectural features and high end finishes. Feel inspired by open sight line that embrace the outdoors, crowned by stunning coffered ceiling. "));
        items.add(new PropertyDomain("House","House With Great View","District 2 VN","h_2",800,2,2,false,4.9,"This 2 bed /1 bath home boast enormous, open-living room plan, accented by striking architectural features and high end finishes. Feel inspired by open sight line that embrace the outdoors, crowned by stunning coffered ceiling. "));
        items.add(new PropertyDomain("Villa","Classic Villa","District 2 VN","h_3",15000,6,5,true,4.8,"This 2 bed /1 bath home boast enormous, open-living room plan, accented by striking architectural features and high end finishes. Feel inspired by open sight line that embrace the outdoors, crowned by stunning coffered ceiling. "));

        binding.recommendView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterRecommended = new RecommendedAdapter(items);
        binding.recommendView.setAdapter(adapterRecommended);

        binding.nearbyView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapterNearby = new NearbyAdapter(items);
        binding.nearbyView.setAdapter(adapterNearby);
    }

    private void initLocation() {
        String[] items=new String[]{"District 1, VietNam", "District 2, VietNam"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.locationSpin.setAdapter(adapter);
    }
}