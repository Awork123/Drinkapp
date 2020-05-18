package com.example.drinkapp;

public class DrinkViewItems {
    private int mDrinkImage;
    private int mChecked;
    private String mDrinkName;
    private String mDrinkDescription;
    private String mDrinkprice;

    public DrinkViewItems(int drinkImage, String drinkName, String drinkDescription, String drinkPrice, int checked){
        mDrinkImage = drinkImage;
        mDrinkName = drinkName;
        mDrinkDescription = drinkDescription;
        mDrinkprice = drinkPrice;
        mChecked = checked;
    }
    public void changeImage(int drawable){
        mChecked = drawable;
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
    public int getChecked(){return mChecked;}
}
