package com.example.drinkapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DrinksViewActivity extends RecyclerView.Adapter<DrinksViewActivity.DrinksViewHolder> {
    private ArrayList<DrinkViewItems> mDrinkList;

    public static class DrinksViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkMame;
        public TextView drinkDescription;
        public ImageView drinkImage;

        public DrinksViewHolder(View view) {
            super(view);
            drinkMame = view.findViewById(R.id.DrinksName);
            drinkDescription = view.findViewById(R.id.DrinksDescription);
            drinkImage = view.findViewById(R.id.DrinkImage);
        }
    }

    public DrinksViewActivity(ArrayList<DrinkViewItems> drinkList) {
        mDrinkList = drinkList;
    }

    @Override
    public DrinksViewActivity.DrinksViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelist_drinkviewlist, parent, false);
        return new DrinksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DrinksViewHolder holder, int position) {
        DrinkViewItems currentItem = mDrinkList.get(position);
        holder.drinkImage.setImageResource(currentItem.getImageDrink());
        holder.drinkMame.setText(currentItem.getDrinkName());
        holder.drinkDescription.setText(currentItem.getDrinkDescription());
    }

    @Override
    public int getItemCount() {
        return mDrinkList.size();
    }
}