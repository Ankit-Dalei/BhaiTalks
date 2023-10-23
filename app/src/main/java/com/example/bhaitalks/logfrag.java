package com.example.bhaitalks;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class logfrag extends Fragment {
    EditText ut,pt;
    Button button;
    TextView text;

    public logfrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_logfrag, container, false);
        text=view.findViewById(R.id.txt);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i=new Intent(getActivity(), HomeActivity.class);
//                startActivity(i);
            }
        });
        button=view.findViewById(R.id.button5);
        ut=view.findViewById(R.id.editTextText);
        button.setOnClickListener((v)->{
                String uid=ut.getText().toString().trim();
                Intent i=new Intent(getActivity(), WelcomeActivity.class);
                i.putExtra("uid",uid);
                startActivity(i);
        });
        return view;
    }
}