package com.example.drinkapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OrderDrinksActivity extends AppCompatActivity implements Callback {

    private ArrayList< DrinkViewItems > mDrinkList;
    private RecyclerView recyclerView;
    private DrinksViewActivity mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int statePosition;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdrinks);

        createDrinkList();
        //showDrinksRecycleView();

    }

    public void changeItem(int position) {
        mDrinkList.get(position).check();
    }

    private void createDrinkList() {
        SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
        String machineID = preferences.getString("MachineID", "Helloer") ;
        String path = "drinks/" + machineID;
        ServerRequests sr = new ServerRequests(path, null, null, this, HTTPRequestType.Get);
        mDrinkList = new ArrayList<>();
        sr.execute();
        /*

        mDrinkList.add(new DrinkViewItems("", "Vodka+Cola"));
        mDrinkList.add(new DrinkViewItems("","Vodka+Fanta"));
        mDrinkList.add(new DrinkViewItems( "", "Rom+Cola"));
        mDrinkList.add(new DrinkViewItems( "","Vodka+Cola"));
         */
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDrinksRecycleView() {
        recyclerView = findViewById(R.id.drinksList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mAdapter = new DrinksViewActivity(mDrinkList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(position -> {
            //Easier to track of the amount of elements, than if we used traditional for loop.
            mDrinkList.forEach(DrinkViewItems::unCheck);
            changeItem(position);
            recyclerView.setAdapter(mAdapter);
        });
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        switch (response.code()) {
            case 200:
                Gson gson = new Gson();
                String body = Objects.requireNonNull(response.body()).string();
                System.out.println(body);
                DrinkContent[] drinksContent = gson.fromJson(body, DrinkContent[].class);
                for (int i = 0; i < drinksContent.length; i++) {
                    mDrinkList.add(drinksContent[i].toViewItem());
                }
                runOnUiThread(this::showDrinksRecycleView);
                break;
            default:
        }
    }

    class DrinkContent {
        String id;
        String name;
        DrinkContent(String id, String name) {
            this.id = id;
            this.name = name;
        }

        DrinkViewItems toViewItem() {
            return new DrinkViewItems(id, name);
        }
    }
}