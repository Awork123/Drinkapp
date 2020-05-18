package com.example.drinkapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class OrderDrinksActivity extends AppCompatActivity {

    private ArrayList<DrinkViewItems> mDrinkList;
    private RecyclerView recyclerView;
    private DrinksViewActivity mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdrinks);

        createDrinkList();
        showDrinksRecycleView();

    }

    public void changeItem(int position, int drawable) {
        mDrinkList.get(position).changeImage(drawable);
        mAdapter.notifyItemChanged(position);
    }

    private void createDrinkList() {
        mDrinkList = new ArrayList<>();
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_history, "Vodka+Cola", "Its good", "15kr,-", R.drawable.ic_face_black));
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_account, "Vodka+Fanta", "Aight", "17kr,-", R.drawable.ic_face_black));
        mDrinkList.add(new DrinkViewItems(R.drawable.ic_more_options, "Rom+Cola", "Fine, I guess", "20kr,-", R.drawable.ic_face_black));
    }
    private void showDrinksRecycleView() {
        recyclerView = findViewById(R.id.drinksList);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mAdapter = new DrinksViewActivity(mDrinkList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new DrinksViewActivity.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                changeItem(position, R.drawable.ic_getdrink);
            }
        });
    }
}