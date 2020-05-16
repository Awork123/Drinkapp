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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword;
    Button btSubmit, btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);

        btSubmit = findViewById(R.id.bt_submit);
        btSignUp = findViewById(R.id.bt_sign_up);

        btSubmit.setOnClickListener(this);
        btSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btSubmit) {
            if (etUsername.getText().toString().equals("Simon") &&
                    etPassword.getText().toString().equals("Bjergø")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(
                        MainActivity.this
                );
                builder.setIcon(R.drawable.ic_mood);
                builder.setTitle("Succesfully logged in!");
                builder.setMessage("Welcome and drink!!");

                builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent mainMenu = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(mainMenu);
                        finish();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
            }
        }
        if (view == btSignUp){
            Intent signUpIntent = new Intent(this, SignUpActivity.class);
            startActivity(signUpIntent);
            finish();
        }

    }
}
