package com.example.bhaitalks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;


public class SignIn_welcome extends AppCompatActivity {
    TextView tdt;
    DBhelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_welcome);
        myDb=new DBhelper(this);
        String uname=getIntent().getStringExtra("uname");
        String Pass=getIntent().getStringExtra("Pass");
        String Email=getIntent().getStringExtra("Email");
        String phon=getIntent().getStringExtra("phon");
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                boolean isInserted= myDb.insertData( uname, Email, phon, Pass);
                if(isInserted==true)
                    Toast.makeText(SignIn_welcome.this, "Data Inserted Successfully.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SignIn_welcome.this,"Failed Insertion.",Toast.LENGTH_LONG).show();
            }
        },3000);

    }
}