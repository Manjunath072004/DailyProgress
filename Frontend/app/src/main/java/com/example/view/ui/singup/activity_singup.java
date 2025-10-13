
package com.example.view.ui.singup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.view.R;
import com.example.view.api.ApiClient;
import com.example.view.api.ApiService;
import com.example.view.model.SignupRequest;
import com.example.view.model.SignupResponse;
import com.example.view.ui.login.activity_login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class activity_singup extends AppCompatActivity {

    private EditText usernameEt, emailEt, phoneEt, passwordEt;
    private Button signupBtn;
    private TextView signinText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        // Initialize Views
        usernameEt = findViewById(R.id.username);
        emailEt = findViewById(R.id.email);
        phoneEt = findViewById(R.id.phone_number);
        passwordEt = findViewById(R.id.password);
        signupBtn = findViewById(R.id.SingupButton);
        signinText = findViewById(R.id.signinText);

        // Signup button click
        signupBtn.setOnClickListener(v -> signupUser());

        // Navigate to Login page
        signinText.setOnClickListener(v -> {
            Intent intent = new Intent(activity_singup.this, activity_login.class);
            startActivity(intent);
            finish();
        });
    }

    private void signupUser() {
        // Get user inputs
        String username = usernameEt.getText().toString().trim();
        String email = emailEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();

        // Basic validation
        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SignupRequest request = new SignupRequest(username, email, phone, password);

        ApiService apiService = ApiClient.getClient(null).create(ApiService.class);
        Call<SignupResponse> call = apiService.signup(request);

        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(activity_singup.this,
                            response.body().getMessage() + " Please login.",
                            Toast.LENGTH_LONG).show();

                    // Go to login page
                    Intent intent = new Intent(activity_singup.this, activity_login.class);
                    startActivity(intent);
                    finish();
                } else {
                    try {
                        String error = response.errorBody().string();
                        Toast.makeText(activity_singup.this, "Signup Failed: " + error, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(activity_singup.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(activity_singup.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


