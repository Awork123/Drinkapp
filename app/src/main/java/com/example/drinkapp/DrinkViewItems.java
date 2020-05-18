package com.example.drinkapp;

public class DrinkViewItems {
    private int mDrinkImage;
    private String mDrinkName;
    private String mDrinkDescription;

    public DrinkViewItems(int drinkImage, String drinkName, String drinkDescription){
        mDrinkImage = drinkImage;
        mDrinkName = drinkName;
        mDrinkDescription = drinkDescription;
    }
    public int getImageDrink() {
        return mDrinkImage;
    }
    public String getDrinkName() {
        return mDrinkName;
    }
    public String getDrinkDescription() {
        return mDrinkDescription;
    }
}
