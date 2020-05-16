package com.example.drinkapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText signupUsername, signUpPassword;
    Button btLoginReturn, btSignUpToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupUsername = findViewById(R.id.signup_Username);
        signUpPassword = findViewById(R.id.signup_Password);

        btLoginReturn = findViewById(R.id.bt_go_back);
        btSignUpToServer = findViewById(R.id.bt_sign_up_to_server);

        btLoginReturn.setOnClickListener(this);
        btSignUpToServer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btLoginReturn){
            Intent returnToLogin = new Intent(this, MainActivity.class);
            startActivity(returnToLogin);
            finish();
        }
    }
}
