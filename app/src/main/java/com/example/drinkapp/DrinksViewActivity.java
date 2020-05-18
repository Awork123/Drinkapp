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
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class DrinksViewHolder extends RecyclerView.ViewHolder {
        public TextView drinkMame;
        public TextView drinkDescription;
        public ImageView drinkImage;
        public TextView drinkPrice;
        public ImageView checkedDrinks;

        public DrinksViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            drinkMame = view.findViewById(R.id.DrinksName);
            drinkDescription = view.findViewById(R.id.DrinksDescription);
            drinkImage = view.findViewById(R.id.DrinkImage);
            drinkPrice = view.findViewById(R.id.DrinkPrice);
            checkedDrinks = view.findViewById(R.id.CheckedDrink);

            view.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    public DrinksViewActivity(ArrayList<DrinkViewItems> drinkList) {
        mDrinkList = drinkList;
    }

    @Override
    public DrinksViewActivity.DrinksViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelist_drinkviewlist, parent, false);
        return new DrinksViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(DrinksViewHolder holder, int position) {
        DrinkViewItems currentItem = mDrinkList.get(position);
        holder.drinkImage.setImageResource(currentItem.getImageDrink());
        holder.drinkMame.setText(currentItem.getDrinkName());
        holder.drinkDescription.setText(currentItem.getDrinkDescription());
        holder.drinkPrice.setText(currentItem.getDrinkPrice());
        holder.checkedDrinks.setImageResource(currentItem.getChecked());
    }

    @Override
    public int getItemCount() {
        return mDrinkList.size();
    }
}