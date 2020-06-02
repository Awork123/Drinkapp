package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AccountEditActivity extends AppCompatActivity {
    //Define our needed widgets
    EditText editTextName, editTextEmail, editTextPhonenumber;
    TextView textName, textEmail, textPhonenumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set our layout equal to the corresponding XML file.
        setContentView(R.layout.activity_account_edit);

        //Bind our defined widgets to the widgets on the XML file.
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhonenumber = findViewById(R.id.editTextPhonenumber);
        textName = findViewById(R.id.textName);
        textEmail = findViewById(R.id.textEmail);
        textPhonenumber = findViewById(R.id.textPhonenumber);
    }
}
