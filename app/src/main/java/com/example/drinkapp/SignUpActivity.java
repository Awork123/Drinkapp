package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText signupUsername, signUpPassword;
    Button btLoginReturn, btSignUpToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupUsername = findViewById(R.id.signup_Username);
        signUpPassword = findViewById(R.id.signup_Password);

        btLoginReturn = findViewById(R.id.bt_go_back);
        btSignUpToServer = findViewById(R.id.bt_sign_up_to_server);

        btLoginReturn.setOnClickListener(this);
        btSignUpToServer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btLoginReturn){
            Intent returnToLogin = new Intent(this, MainActivity.class);
            startActivity(returnToLogin);
            finish();
        }
        if (view == btSignUpToServer) {
            SignUp serverSignUpRequest = new SignUp(signupUsername.getText().toString(), signUpPassword.getText().toString());
            ServerRequests<SignUp> sr = new ServerRequests<SignUp>(serverSignUpRequest, new signUpCallBack());
            sr.execute();
            Intent goBackToLogin = new Intent(this, MainActivity.class);
            startActivity(goBackToLogin);
            finish();
        }
    }
    class SignUp {
        String mail;
        String password;

        SignUp(String uname, String pword) {
            mail = uname;
            password = pword;
        }
    }
    class signUpCallBack implements Callback {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                System.out.println("failed");
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response.body().string());
                System.out.println("Response Received");
            }
    }
}
