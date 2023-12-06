package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandsignup.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {
ActivitySignupBinding binding;
DatabaseHelper databaseHelper;
EditText edtEmail, edtPassword,edtConfirmpw;
TextView redirectLogin ;
Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_signup);
        databaseHelper = new DatabaseHelper(this);
        edtEmail= findViewById(R.id.signup_email);
        edtPassword= findViewById(R.id.signup_passwword);
        edtConfirmpw= findViewById(R.id.signup_confirm);
        redirectLogin = findViewById(R.id.loginRedirectText);
        btnSignup = findViewById(R.id.signup_btn);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmpassword = edtConfirmpw.getText().toString();

                if (email.equals("") || password.equals("")|| confirmpassword.equals("")) {
                    Toast.makeText(SignupActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (password.equals(confirmpassword)) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);

                        if (checkUserEmail == false) {
                            Boolean insert = databaseHelper.insertData(email, password);
                            if (insert == true) {
                                Toast.makeText(SignupActivity.this, "Signup successfully", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(i);
                            }
                            else {
                                Toast.makeText(SignupActivity.this, "Singup failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignupActivity.this, "User already exists. Please login!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        redirectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}