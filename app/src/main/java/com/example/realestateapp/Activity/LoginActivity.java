package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.realestateapp.API.ApiService;
import com.example.realestateapp.databinding.ActivityLoginBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    private List<User> mListUser;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getListUsers();
        mListUser=new ArrayList<>();

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });

        binding.SignupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void clickLogin()
    {
        String strUsername = binding.UsernameTxt.getText().toString().trim();
        String strPassword = binding.PasswordTxt.getText().toString().trim();

        if (mListUser == null || mListUser.isEmpty()) {
            return;
        }

        boolean isHasUser = false;
        for (User user : mListUser){
            if (strUsername.equals(user.getUsername()) && strPassword.equals(user.getPassword())) {
                isHasUser = true;
                mUser = user;
                break;
            }
        }

        if (isHasUser) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("user", mUser); // Đính kèm dữ liệu người dùng
            startActivity(intent); // Bắt đầu MainActivity
        }

        else {
            Toast.makeText(LoginActivity.this, "Username or password invalid", Toast.LENGTH_SHORT).show();
        }
    }

    private void getListUsers()
    {
        ApiService.apiService.getListUsers()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUser = response.body();
                        Log.e("List Users", mListUser.size() + "");
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Call api error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}