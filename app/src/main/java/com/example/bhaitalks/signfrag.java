package com.example.bhaitalks;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class signfrag extends Fragment {
    EditText username,password,phone,email;
    Button button;

    public signfrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signfrag, container, false);
        button=view.findViewById(R.id.button2);
        username=view.findViewById(R.id.editTextText2);
        password=view.findViewById(R.id.editTextText6);
        phone=view.findViewById(R.id.editTextText3);
        email=view.findViewById(R.id.editTextText5);
        button.setOnClickListener((v)->{
            String uname=username.getText().toString().trim();
            String Pass=password.getText().toString().trim();
            String Email=email.getText().toString().trim();
            String phon=phone.getText().toString().trim();
            Intent i=new Intent(getActivity(), SignIn_welcome.class);
            i.putExtra("uname",uname);
            i.putExtra("Pass",Pass);
            i.putExtra("Email",Email);
            i.putExtra("phon",phon);
            startActivity(i);
        });
        return view;
    }
}