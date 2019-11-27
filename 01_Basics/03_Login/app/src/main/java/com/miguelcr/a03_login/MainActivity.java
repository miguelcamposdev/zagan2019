package com.miguelcr.a03_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etPass;
    Button btnLogin;
    TextView tvAppName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.editTextEmail);
        etPass = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        tvAppName = findViewById(R.id.textViewAppName);

        // Change the font the type for the App Name
        Typeface fontSchool = Typeface.createFromAsset(getAssets(), "school.ttf");
        tvAppName.setTypeface(fontSchool);

        // Click event on Login Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPass.getText().toString();

                if(email.isEmpty()) {
                    etEmail.setError("Write an email please!");
                } else if(password.isEmpty()) {
                    etPass.setError("Write a password please!");
                } else if(email.equals("admin@admin.com") && password.equals("1234")) {
                    // Login ok
                    Intent i = new Intent(
                            MainActivity.this,
                            DashboardActivity.class
                    );
                    startActivity(i);
                } else {
                    etEmail.setError("Email or password incorrect");
                }
            }
        });
    }
}
