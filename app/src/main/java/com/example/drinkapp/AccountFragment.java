package com.example.drinkapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AccountFragment extends Fragment implements View.OnClickListener {
    //Define our needed widgets
    TextView textName, textGetName;
    Button buttonEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Adds the corresponding XML to activity on runtime.
        View v = inflater.inflate(R.layout.fragment_account, container, false);

        //Bind our defined widgets to the widgets on the XML file.
        textName = v.findViewById(R.id.textName);
        textGetName = v.findViewById(R.id.textGetName);
        buttonEdit = v.findViewById(R.id.buttonEdit);

        //Set an OnClickListener, to make the buttons interactable.
        buttonEdit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        //Switch statements for which buttons is being clicked. While we only have one button for now
        //we still opted for switch, as it is more scalable
        //Start a new activity and take the user there, using Intent.
        switch (v.getId()) {
            case R.id.buttonEdit:
                Intent changeProfile = new Intent(getActivity(), AccountEditActivity.class);
                startActivity(changeProfile);
                break;
        }
    }
}
