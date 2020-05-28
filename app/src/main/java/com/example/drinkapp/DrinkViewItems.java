package com.example.drinkapp;

import java.util.Random;

public class DrinkViewItems {
    private int mDrinkImage;
    private int checked;
    private String mDrinkName;
    private String mID;

    public DrinkViewItems(String id, String name) {
        mDrinkName = name;
        mID = id;
        int image;
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                image = R.drawable.ic_history;
                break;
            case 1:
                image = R.drawable.ic_account;
                break;
            default:
                image = R.drawable.ic_more_options;
                break;
        }
        mDrinkImage = image;
        checked = R.drawable.ic_face_black;
    }

    public String getDrinkName() {
        return mDrinkName;
    }

    public int getChecked() {
        return checked;
    }

    public void check() {
        checked = R.drawable.ic_buydrink;
    }

    public void unCheck() {
        checked = R.drawable.ic_face_black;
    }

    public int getImageDrink() {
        return mDrinkImage;
    }

    public String getmID() {
        return mID;
    }
}

