package com.example.mytask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_singup extends AppCompatActivity {

    // Declare EditText and Button
    EditText username, email, phoneNumber, password, confirmPassword;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup); // your XML file name (update if needed)

        // Initialize views
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone_number);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.coniform_password);
        signUpButton = findViewById(R.id.loginButton); // button id is 'loginButton' in XML

        // Handle button click
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String phone = phoneNumber.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String confirm = confirmPassword.getText().toString().trim();

                // Basic validation
                if (user.isEmpty() || mail.isEmpty() || phone.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
                    Toast.makeText(activity_singup.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(confirm)) {
                    Toast.makeText(activity_singup.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity_singup.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();

                    // ✅ Later, you can add code here to send data to your Django API using Retrofit or Volley
                }
            }
        });
    }
}