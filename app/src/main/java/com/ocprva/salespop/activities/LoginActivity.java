package com.ocprva.salespop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ocprva.salespop.R;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView btnSignUp;
    TextView btnGuest;
    EditText etMail;
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGuest = findViewById(R.id.btnGuest);

        etMail = findViewById(R.id.etMail);
        etPwd = findViewById(R.id.etPwd);
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.btnLogin:
                if(!etMail.getText().toString().equals("") && !etPwd.getText().toString().equals("")){
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                break;

            case R.id.btnSignUp:
                intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.btnGuest:
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}