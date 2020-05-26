package com.example.drinkapp;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderDrinksActivity extends AppCompatActivity {

    private ArrayList<DrinkViewItems> mDrinkList;
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
        showDrinksRecycleView();

    }

    public void changeItem(int position) {
        mDrinkList.get(position).check();
    }

    private void createDrinkList() {
        mDrinkList = new ArrayList<>();
        mDrinkList.add(new DrinkViewItems("", "Vodka+Cola"));
        mDrinkList.add(new DrinkViewItems("","Vodka+Fanta"));
        mDrinkList.add(new DrinkViewItems( "", "Rom+Cola"));
        mDrinkList.add(new DrinkViewItems( "","Vodka+Cola"));
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
}