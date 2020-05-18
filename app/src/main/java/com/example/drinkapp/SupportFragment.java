package com.example.drinkapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SupportFragment extends Fragment implements View.OnClickListener {
    Button buttonPaymentInfoOptions, buttonGeneralInfoOptions, buttonInfoMyOrder, emailSupport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_support, container, false);

        buttonPaymentInfoOptions = v.findViewById(R.id.bnPayment);
        buttonGeneralInfoOptions = v.findViewById(R.id.bnGeneralInfo);
        buttonInfoMyOrder = v.findViewById(R.id.bnMyOrder);
        emailSupport = v.findViewById(R.id.bnEmailHelp);

        buttonPaymentInfoOptions.setOnClickListener(this);
        buttonGeneralInfoOptions.setOnClickListener(this);
        buttonInfoMyOrder.setOnClickListener(this);
        emailSupport.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bnPayment:
                Intent goToPaymentInfo = new Intent(getActivity(), SupportPaymentActivity.class);
                startActivity(goToPaymentInfo);
                break;
            case R.id.bnGeneralInfo:
                Intent goToWhatIs = new Intent(getActivity(), SuppportWhatIsActivity.class);
                startActivity(goToWhatIs);
                break;
            case R.id.bnMyOrder:
                Intent goToMyOrderInfo = new Intent(getActivity(), SupportMyOrderActivity.class);
                startActivity(goToMyOrderInfo);
                break;
            case R.id.bnEmailHelp:
                Intent emailSupport = new Intent(getActivity(), SupportEmail.class);
                startActivity(emailSupport);
                break;
        }
    }
}
