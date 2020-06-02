package com.example.drinkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    //Define our needed widgets
    EditText signupUsername, signUpPassword;
    Button btLoginReturn, btSignUpToServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set our layout equal to the corresponding XML file.
        setContentView(R.layout.activity_sign_up);

        //Bind our defined widgets to the widgets on the XML file.
        signupUsername = findViewById(R.id.signup_Username);
        signUpPassword = findViewById(R.id.signup_Password);

        btLoginReturn = findViewById(R.id.bt_go_back);
        btSignUpToServer = findViewById(R.id.bt_sign_up_to_server);

        //Set an OnClickListener, to make the buttons interactable.
        btLoginReturn.setOnClickListener(this);
        btSignUpToServer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Switch statements for which buttons is being clicked, and each case is a button being clicked.
        switch (view.getId()) {
            case R.id.bt_sign_up_to_server:
                //Send a ServerRequest with the password and username the user has typed in our editText fields as Strings.
                //The path makes the user sign up
                //After sending the request, finish current activity to prevent activity stacking
                SignUp serverSignUpRequest = new SignUp(signupUsername.getText().toString(), signUpPassword.getText().toString());
                ServerRequests<SignUp> sr = new ServerRequests<SignUp>("user/register", serverSignUpRequest, null, new signUpCallBack(), HTTPRequestType.Post);
                sr.execute();
                finish();
                break;
            case R.id.bt_go_back:
                //Finish the current activity. This button function as if the user clicked the built in back button, as is merely here for design.
                finish();
                break;
        }
    }

    class SignUp {
        //To be used to encode later
        String mail;
        String password;

        SignUp(String uname, String pword) {
            //To be used to encode later
            mail = uname;
            password = pword;
        }
    }

    class signUpCallBack implements Callback {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
            //Display a popup on the UI as to give the user feedback about the connection to the server
            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Unable to connect to server", Toast.LENGTH_SHORT).show());
            //If the callback fails, we cancel the request.
            call.cancel();
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            //Display a popup on the UI as to give the user feedback about the connection to the server
            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Your account has been registered!", Toast.LENGTH_SHORT).show());
        }
    }
}
