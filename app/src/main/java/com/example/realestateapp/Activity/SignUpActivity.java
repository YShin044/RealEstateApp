package com.example.realestateapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.realestateapp.API.ApiService;
import com.example.realestateapp.R;
import com.example.realestateapp.databinding.ActivityLoginBinding;
import com.example.realestateapp.databinding.ActivitySignUpBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSign();
            }
        });
    }

    private void sendUser(User user) {

        ApiService.apiService.sendUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(SignUpActivity.this, "Sign Up Success ", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, "Call api error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void clickSign() {
        String strUsername = binding.UsernameTxtSignUp.getText().toString().trim();
        String strPassword = binding.PasswordTxtSignUp.getText().toString().trim();
        String strName = binding.NameTxtSignUp.getText().toString().trim();
        String strPhoneNumber = binding.PhoneNumberTxtSignUp.getText().toString().trim();

        User user = new User(5, strUsername, strPassword,"3.png", strName,strPhoneNumber);
        sendUser(user);
    }
}