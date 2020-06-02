package com.example.drinkapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Define our needed widgets
    EditText etUsername, etPassword;
    Button btSubmit, btSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set our layout equal to the corresponding XML file.
        setContentView(R.layout.activity_main);

        //Bind our defined widgets to the widgets on the XML file.
        etUsername = findViewById(R.id.et_Username);
        etPassword = findViewById(R.id.et_Password);

        btSubmit = findViewById(R.id.bt_submit);
        btSignUp = findViewById(R.id.bt_sign_up);

        //Set an OnClickListener, to make the buttons interactable.
        btSubmit.setOnClickListener(this);
        btSignUp.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        //Switch statements for which buttons is being clicked, and each case is a button being clicked.
        //We do this, as it is more clean and more scalibale.
        switch (view.getId()) {
            case R.id.bt_sign_up:
                //Start a new activity and take the user there, using Intent.
                Intent signUpIntent = new Intent(this, SignUpActivity.class);
                startActivity(signUpIntent);
                break;
            case R.id.bt_submit:
                //Send a loginType ServerRequest with the password and username the user has typed in our editText fields as Strings.
                //The path defines which kind of request is send
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                ServerRequests sr = new ServerRequests("user/login", null, LoginType.basic(username, password), new LoginCallBack(), HTTPRequestType.Post);
                sr.execute();
                break;
        }
    }

    class LoginCallBack implements Callback {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
            //If the callback fails, we cancel the request.
            call.cancel();
            //Display a popup on the UI as to give the user feedback about the connection to the server
            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Unable to connect to server", Toast.LENGTH_SHORT).show());
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            //Switch statements for which response is given. 200 means 'accepted'.
            switch (response.code()) {
                case 200:
                    //Display a popup on the UI with picture and text, that shows the user they successfully logged in.
                    runOnUiThread(() -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setIcon(R.drawable.ic_mood);
                        builder.setTitle("Successfully logged in!");
                        builder.setMessage("Welcome and drink!!");
                        builder.setNegativeButton("YES", (dialog, which) -> {
                            //we cancel the popup box and start a new activity and take the user there, using Intent.
                            dialog.cancel();
                            Intent mainMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
                            startActivity(mainMenu);
                            //We finish our activity, to prevent activity stacking.
                            finish();
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    });

                    Gson gson = new Gson();
                    String token = gson.fromJson(response.body().string(), Token.class).token;
                    SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Token", token);
                    editor.apply();
                    System.out.println(token);
                    ServerRequests sr = new ServerRequests("machine", null, null, new MachineHandler(), HTTPRequestType.Get);
                    sr.execute();
                    break;
                default:
                    //Display a popup on the UI as to give the user feedback about the connection to the server
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Invalid password or username", Toast.LENGTH_SHORT).show());
            }
        }
    }

    class MachineHandler implements Callback {
        @Override
        public void onFailure(@NotNull Call call, @NotNull IOException e) {
        }

        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            switch (response.code()) {
                case 200:
                    Gson gson = new Gson();
                    Machine[] machines = gson.fromJson(response.body().string(), Machine[].class);
                    String id = machines[0].id;
                    SharedPreferences preferences = getSharedPreferences("App", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("MachineID", id);
                    editor.apply();
                    break;
                default:
                    //Display a popup on the UI as to give the user feedback about the connection to the server
                    runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Invalid password or username", Toast.LENGTH_SHORT).show());
            }
        }
    }


    class Machine {
        String id;
    }


    private class Token {
        String token;
    }
}
