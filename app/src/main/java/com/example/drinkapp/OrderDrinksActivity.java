package com.example.drinkapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderDrinksActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Drinkslist activated");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdrinks);

        ArrayList<DrinkViewItems> drinkList = new ArrayList<>();
        drinkList.add(new DrinkViewItems(R.drawable.ic_history, "Vodka+Cola", "Its good"));
        drinkList.add(new DrinkViewItems(R.drawable.ic_account, "Vodka+Fanta", "Aight"));
        drinkList.add(new DrinkViewItems(R.drawable.ic_more_options, "Rom+Cola", "Fine, I guess"));

        recyclerView = findViewById(R.id.drinksList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new DrinksViewActivity(drinkList);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

    }

}