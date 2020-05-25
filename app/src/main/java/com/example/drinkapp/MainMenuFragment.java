package com.example.drinkapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


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
            SharedPreferences preferences = getContext().getSharedPreferences("App", Context.MODE_PRIVATE);
            String machineID = preferences.getString("MachineID", "Helloer") ;
            String path = "drinks/" + machineID;
            ServerRequests sr = new ServerRequests(path, null, null, new DrinksCallback(), HTTPRequestType.Get);
            sr.execute();

            Intent orderDrinks = new Intent(getActivity(), OrderDrinksActivity.class);
            startActivity(orderDrinks);
        }
    }

    class DrinksCallback implements Callback {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {

        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

        }
    }
}