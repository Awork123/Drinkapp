package com.example.drinkapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Base64;

public enum LoginType {
    // For using Token authentication
    Token,
    // For using password and username
    Basic;

    public String hash;

    // Convenience function for making a basic authentication
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

    // Convenience function for making a basic authentication
    @RequiresApi(api = Build.VERSION_CODES.O)
    static LoginType token(String token) {
        LoginType login = Token;

        login.hash = Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(token.getBytes());
        return login;
    }
}
