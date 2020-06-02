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
    HTTPRequestType requestType;

    ServerRequests(String path, @Nullable T object, @Nullable LoginType loginType, Callback callback, HTTPRequestType requestType) {
        // Payload
        this.object = object;
        // The class to be called when the request has executed
        this.callback = callback;
        // The given auth type used for performing user restricted requests
        this.loginType = loginType;
        // The endpoint at which the request is performed against
        this.path = path;
        // The semantic HTTP request
        this.requestType = requestType;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            // Prepare server for the incomming media type
            MediaType JSON = MediaType.get("application/json; charset=utf-8");
            Gson gson = new Gson();

            // Turn the payload into a json object
            String userJson = gson.toJson(this.object);
            OkHttpClient client = new OkHttpClient();

            // Begin the request builder with the path
            RequestBody body = RequestBody.create(userJson, JSON);
            Request.Builder reqBuilder = new Request.Builder()
                    .url("http://192.168.0.14/" + path);

            // Set the HTTP request type
            switch (requestType) {
                case Get:
                    reqBuilder = reqBuilder.get();
                    break;
                case Post:
                    reqBuilder = reqBuilder.post(body);
                    System.out.println("Time to print");
                    ;
                    break;
            }

            // If there's a login type, then put it on the request builder
            if (loginType != null) {
                switch (loginType) {
                    case Basic:
                        reqBuilder.header("Authorization", "Basic " + loginType.hash);
                        break;
                    case Token:
                        reqBuilder.header("Authorization", "Token " + loginType.hash);
                        break;
                }
            }

            // Call the callback when the request has completed
            client.newCall(reqBuilder.build()).enqueue(this.callback);

        } catch (Exception e) {
            // Print the error
            e.printStackTrace();
        }
        return null;
    }
}

