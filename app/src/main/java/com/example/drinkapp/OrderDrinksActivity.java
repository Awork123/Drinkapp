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

    public void changeItem(int position, int drawable) {
        mDrinkList.get(position).changeImage(drawable);
    }

    private void createDrinkList() {
        mDrinkList = new ArrayList<>();
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_history, "Vodka+Cola", "Its good", "15kr,-", R.drawable.ic_face_black));
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_account, "Vodka+Fanta", "Aight", "17kr,-", R.drawable.ic_face_black));
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_more_options, "Rom+Cola", "Fine, I guess", "20kr,-", R.drawable.ic_face_black));
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
            mDrinkList.forEach((drink) -> drink.changeImage(R.drawable.ic_face_black));
            changeItem(position, R.drawable.ic_getdrink);
            recyclerView.setAdapter(mAdapter);
        });
    }
}