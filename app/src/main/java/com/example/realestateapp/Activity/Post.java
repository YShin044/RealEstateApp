package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.realestateapp.R;

public class Post extends AppCompatActivity {
    private RecyclerView recyclerViewList;
    private com.example.realestateapp.Helper.ManageFavorite ManageFavorite;
    TextView deliveryTxt, emptyTxt;
    private double tax;
    private ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initView();
        initList();
        bottomNavigation();
    }
    private void bottomNavigation() {
        LinearLayout linearLayout = findViewById(R.id.PostBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Post.this, Post.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Post.this, MainActivity.class));
            }
        });
    }
    private void initView() {
        recyclerViewList = findViewById(R.id.recommendView);
        emptyTxt = findViewById(R.id.emptyTxt);
        scrollView = findViewById(R.id.scrollview3);
        recyclerViewList = findViewById(R.id.favoriteview);
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
    }
    private void setupBottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout favBtn = findViewById(R.id.FAVBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(Post.this, MainActivity.class)));
        favBtn.setOnClickListener(v -> startActivity(new Intent(Post.this, FavoriteList.class)));
    }
}