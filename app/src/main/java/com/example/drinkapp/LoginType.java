package com.example.drinkapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public enum LoginType {
    Token,
    Basic;

    public String hash;

    @RequiresApi(api = Build.VERSION_CODES.O)
    static LoginType basic(String username, String password) {
        LoginType login = Basic;

        String loginString = username + ":" + password;
        login.hash = Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(loginString.getBytes());

        return login;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    static LoginType token(String token) {
        LoginType login =  Token;

        login.hash = Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(token.getBytes());
        return login;
    }
}
