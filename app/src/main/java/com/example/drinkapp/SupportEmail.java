package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SupportEmail extends AppCompatActivity {

    //Define our needed widgets
    private EditText mEditTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set our layout equal to the corresponding XML file.
        setContentView(R.layout.activity_support_email);

        //Bind our defined widgets to the widgets on the XML file.
        mEditTextMessage = findViewById(R.id.editemailtext);

        //Set an OnClickListener, to make the buttons interactable.
        Button buttonSendEmail = findViewById(R.id.buttonsendemail);

        //Set an OnClickListener, to make the buttons interactable.
        buttonSendEmail.setOnClickListener(v -> sendMail());
    }

    private void sendMail() {
        //Create the title and the recipient, to make easier to email.
        //Change the body of the mail equal to the text written in the app, as a string
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
