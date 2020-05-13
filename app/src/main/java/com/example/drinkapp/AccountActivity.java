package com.example.drinkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    TextView textName, textGetName;
    Button buttonEdit;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        textName = findViewById(R.id.textEmail);
        textGetName = findViewById(R.id.textEmail);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(this);

        drawerLayout = findViewById(R.id.drawer_layout_account);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_account);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonEdit) {
            Intent changeProfile = new Intent(this, AccountEditActivity.class);
            startActivity(changeProfile);
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
            case R.id.nav_account:
                break;
            case R.id.nav_home:
                Intent mainMenu = new Intent(AccountActivity.this, MainMenu.class);
                startActivity(mainMenu);
                finish();
                break;
            case R.id.nav_help:
                Intent supportMenu = new Intent(AccountActivity.this, SupportActivity.class);
                startActivity(supportMenu);
                finish();
                break;
            case R.id.nav_history:
                Intent historyMenu = new Intent(AccountActivity.this, HistoryActivity.class);
                startActivity(historyMenu);
                finish();
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(AccountActivity.this, MainActivity.class);
                startActivity(logout);
                finish();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
