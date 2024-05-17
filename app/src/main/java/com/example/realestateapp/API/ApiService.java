package com.example.realestateapp.API;

import com.example.realestateapp.Activity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Currency;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //Link API: http://localhost:8810/api/uploadimage

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-đ HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://172.16.31.89:8810/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("uploadimage")
    Call<List<User>> getListUsers();
}