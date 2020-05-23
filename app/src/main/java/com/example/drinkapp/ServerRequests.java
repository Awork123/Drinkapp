package com.example.drinkapp;

import android.os.AsyncTask;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ServerRequests<T> extends AsyncTask {
    T object;
    Callback callback;
    LoginType loginType;
    String path;

    ServerRequests(String path, @Nullable T object, @Nullable LoginType loginType, Callback callback) {
        this.object = object;
        this.callback = callback;
        this.loginType = loginType;
        this.path = path;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
            Gson gson = new Gson();

            String userJson = gson.toJson(this.object);
            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(userJson, JSON);
            Request.Builder reqBuilder = new Request.Builder()
                    .url("http://10.0.1.30/" + path)
                    .post(body);

            if(loginType != null) {
                switch (loginType)
                {
                    case Basic: reqBuilder.header("Authorization", "Basic " + loginType.hash); break;
                    case Token: reqBuilder.header("Authorization", "Token " + loginType.hash); break;
                }
            }

            client.newCall(reqBuilder.build()).enqueue(this.callback);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

