package com.example.drinkapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainMenuFragment extends Fragment implements View.OnClickListener {
    //Define our needed widgets
    Button orderButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Adds the corresponding XML to activity on runtime.
        View v = inflater.inflate(R.layout.fragment_mainmenu, container, false);

        //Bind our defined widgets to the widgets on the XML file.
        orderButton = v.findViewById(R.id.orderDrinks);

        //Set an OnClickListener, to make the buttons interactable.
        orderButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        //Switch statements for which buttons is being clicked. While we only have one button for now
        //we still opted for switch, as it is more scalable
        //Start a new activity and take the user there, using Intent.
        switch (view.getId()) {
            case R.id.orderDrinks:
                Intent orderDrinks = new Intent(getActivity(), OrderDrinksActivity.class);
                startActivity(orderDrinks);
                break;
        }
    }

}