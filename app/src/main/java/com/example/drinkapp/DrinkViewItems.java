package com.example.drinkapp;

public class DrinkViewItems {
    private int mDrinkImage;
    private String mDrinkName;
    private String mDrinkDescription;
    private String mDrinkprice;

    public DrinkViewItems(int drinkImage, String drinkName, String drinkDescription, String drinkPrice){
        mDrinkImage = drinkImage;
        mDrinkName = drinkName;
        mDrinkDescription = drinkDescription;
        mDrinkprice = drinkPrice;
    }
    public void changetext1(String text){
        mDrinkName = text;
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
    public String getDrinkPrice(){
        return mDrinkprice;
    }
}
