package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandsignup.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
DatabaseHelper databaseHelper;
EditText edtemail, edtpassword;
Button btnlogin;
TextView redirectSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_login);
        databaseHelper= new DatabaseHelper(this);
        edtemail = findViewById(R.id.login_email);
        edtpassword = findViewById(R.id.login_passwword);
        btnlogin = findViewById(R.id.login_btn);
        redirectSignup = findViewById(R.id.signupRedirectText);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString();
                String password = edtpassword.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();

                }
                else {
                    Boolean checkAccount = databaseHelper.checkEmailPassword(email, password);

                    if (checkAccount == true) {
                        Toast.makeText(LoginActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent i1= new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i1);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
        redirectSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });
    }
}