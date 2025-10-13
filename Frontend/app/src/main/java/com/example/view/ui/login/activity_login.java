package com.example.view.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.view.R;
import com.example.view.api.ApiClient;
import com.example.view.api.ApiService;
import com.example.view.model.LoginRequest;
import com.example.view.model.LoginResponse;
import com.example.view.ui.home.activity_home;
import com.example.view.ui.singup.activity_singup;
import com.example.view.utils.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_login extends AppCompatActivity {

    private EditText usernameEt, passwordEt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEt = findViewById(R.id.username);
        passwordEt = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginButton);

        loginBtn.setOnClickListener(v -> loginUser());
    }

    private void loginUser() {
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();

        LoginRequest request = new LoginRequest(username, password);

        ApiService apiService = ApiClient.getClient(null).create(ApiService.class);
        Call<LoginResponse> call = apiService.login(request);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    String token = response.body().getAccess();
                    SharedPrefManager.saveToken(activity_login.this, token);

                    Toast.makeText(activity_login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(activity_login.this, activity_home.class);
                    startActivity(intent);
                    finish();
                } else {
//                    Toast.makeText(activity_login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    try {
                        String error = response.errorBody().string();
                        Toast.makeText(activity_login.this, "Login Failed: " + error, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(activity_login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        TextView signupText = findViewById(R.id.signupText);
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(activity_login.this, activity_singup.class);
            startActivity(intent);
            finish();
        });
    }
}