package com.example.bhaitalks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SignIn_welcome extends AppCompatActivity {
    TextView tdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_welcome);
        tdt=(TextView) findViewById(R.id.textView4);
        String uname=getIntent().getStringExtra("uname");
        String Pass=getIntent().getStringExtra("Pass");
        String Email=getIntent().getStringExtra("Email");
        String phon=getIntent().getStringExtra("phon");
        tdt.setText("Hello"+uname);

    }
}