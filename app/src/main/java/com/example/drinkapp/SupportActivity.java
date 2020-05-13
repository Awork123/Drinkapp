package com.example.drinkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class SupportActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    Button buttonPaymentInfoOptions, buttonGeneralInfoOptions, buttonInfoMyOrder, emailSupport;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        buttonPaymentInfoOptions = findViewById(R.id.bnPayment);
        buttonGeneralInfoOptions = findViewById(R.id.bnGeneralInfo);
        buttonInfoMyOrder = findViewById(R.id.bnMyOrder);
        emailSupport = findViewById(R.id.bnEmailHelp);
        buttonPaymentInfoOptions.setOnClickListener(this);
        buttonGeneralInfoOptions.setOnClickListener(this);
        buttonInfoMyOrder.setOnClickListener(this);
        emailSupport.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_layout_support);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_help);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonPaymentInfoOptions) {
            Intent goToPaymentInfo = new Intent(this, SupportPaymentActivity.class);
            startActivity(goToPaymentInfo);
        }
        if (view == buttonInfoMyOrder) {
            Intent goToMyOrderInfo = new Intent(this, SupportMyOrderActivity.class);
            startActivity(goToMyOrderInfo);
        }
        if (view == buttonGeneralInfoOptions) {
            Intent goToWhatIs = new Intent(this, SuppportWhatIsActivity.class);
            startActivity(goToWhatIs);
        }
        if (view == emailSupport) {
            Intent gotoEmailhelp = new Intent(this, SupportEmail.class);
            startActivity(gotoEmailhelp);
        }
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_help:
                break;
            case R.id.nav_home:
                Intent mainMenu = new Intent(SupportActivity.this, MainMenu.class);
                startActivity(mainMenu);
                finish();
                break;
            case R.id.nav_account:
                Intent accountMenu = new Intent(SupportActivity.this, AccountActivity.class);
                startActivity(accountMenu);
                finish();
                break;
            case R.id.nav_history:
                Intent historyMenu = new Intent(SupportActivity.this, HistoryActivity.class);
                startActivity(historyMenu);
                finish();
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(SupportActivity.this, MainActivity.class);
                startActivity(logout);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
