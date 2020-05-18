package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SupportEmail extends AppCompatActivity {

    private EditText mEditTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_email);

        mEditTextMessage = findViewById(R.id.editemailtext);
        Button buttonSendEmail = findViewById(R.id.buttonsendemail);

        buttonSendEmail.setOnClickListener(v -> sendMail());
    }

    private void sendMail() {
        String ourSupportEmail = "Test@gmail.com";
        String[] ourSupportEmailList = ourSupportEmail.split(",");
        String subjectofEmail = "Support for Autobar app";
        String messageEmail = mEditTextMessage.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, ourSupportEmailList);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subjectofEmail);
        emailIntent.putExtra(Intent.EXTRA_TEXT, messageEmail);
        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent, "Choose your email client"));
    }

}
