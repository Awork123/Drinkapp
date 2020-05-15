package com.example.drinkapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainMenuFragment extends Fragment implements View.OnClickListener {
    Button orderButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mainmenu, container, false);

        orderButton = v.findViewById(R.id.orderDrinks);
        orderButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        if (view == orderButton) {
            Intent orderDrinks = new Intent(getActivity(), OrderDrinksActivity.class);
            startActivity(orderDrinks);
        }

    }
}