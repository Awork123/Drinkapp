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
    TextView textName, textGetName;
    Button buttonEdit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);

        textName = v.findViewById(R.id.textName);
        textGetName = v.findViewById(R.id.textGetName);
        buttonEdit = v.findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v == buttonEdit) {
            Intent changeProfile = new Intent(getActivity(), AccountEditActivity.class);
            startActivity(changeProfile);
        }

    }
}
