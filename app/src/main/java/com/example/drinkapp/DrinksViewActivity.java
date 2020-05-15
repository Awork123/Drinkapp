package com.example.drinkapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DrinksViewActivity extends RecyclerView.Adapter<DrinksViewActivity.DrinksViewHolder> {

    private String[] mDataset;

    public static class DrinksViewHolder
            extends RecyclerView.ViewHolder {
        public TextView textView;
        public DrinksViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.DrinksName);
        }
    }

    public DrinksViewActivity(String[] dataset) {
        mDataset = dataset;
    }

    @Override
    public DrinksViewActivity.DrinksViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recyclelist_drinkviewlist, parent, false);

        return new DrinksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DrinksViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}