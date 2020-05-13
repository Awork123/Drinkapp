package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SupportActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonPaymentInfoOptions, buttonGeneralInfoOptions, buttonInfoMyOrder, emailSupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        buttonPaymentInfoOptions = findViewById(R.id.bnPayment);
        buttonGeneralInfoOptions = findViewById(R.id.bnGeneralInfo);
        buttonInfoMyOrder = findViewById(R.id.bnMyOrder);
        emailSupport = findViewById(R.id.bnEmailHelp);
        buttonPaymentInfoOptions.setOnClickListener(this);
        buttonGeneralInfoOptions.setOnClickListener(this);
        buttonInfoMyOrder.setOnClickListener(this);
        emailSupport.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonPaymentInfoOptions) {
            Intent goToPaymentInfo = new Intent(this, SupportPaymentActivity.class);
            startActivity(goToPaymentInfo);
        }
        if (view == buttonInfoMyOrder) {
            Intent goToMyOrderInfo = new Intent(this, SupportMyOrderActivity.class);
            startActivity(goToMyOrderInfo);
        }
        if (view == buttonGeneralInfoOptions) {
            Intent goToWhatIs = new Intent(this, SuppportWhatIsActivity.class);
            startActivity(goToWhatIs);
        }
        if (view == emailSupport) {
            Intent gotoEmailhelp = new Intent(this, SupportEmail.class);
            startActivity(gotoEmailhelp);
        }
    }
}
