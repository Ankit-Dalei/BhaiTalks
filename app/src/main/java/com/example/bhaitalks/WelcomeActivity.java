package com.example.bhaitalks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.zegocloud.uikit.prebuilt.call.config.ZegoNotificationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig;
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationService;

public class WelcomeActivity extends AppCompatActivity {
    TextView tdt;
    DBhelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tdt=(TextView) findViewById(R.id.textView6);
        myDb=new DBhelper(this);
        String uid=getIntent().getStringExtra("uid");
        String pass=getIntent().getStringExtra("pass");
        tdt.setText("Hello"+uid);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                boolean isInserted= myDb.checkuser( uid, pass);
                if(isInserted==true){
                    Toast.makeText(WelcomeActivity.this, "Login Successfully.", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(WelcomeActivity.this,HomeActivity.class);
                    i.putExtra("uid",uid);
                    Startservice(uid);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(WelcomeActivity.this,"Failed Login.",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(WelcomeActivity.this,loginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },3000);
    }

    void Startservice(String uid){
        Application application =getApplication(); // Android's application context
        long appID = 1559378344;   // yourAppID
        String appSign ="d9848db3356794c6b39c4526df4af8b6c79083e807db4e8d2ec16c52ddf54e3e";  // yourAppSign
        String userID =uid; // yourUserID, userID should only contain numbers, English characters, and '_'.
        String userName =uid;   // yourUserName

        ZegoUIKitPrebuiltCallInvitationConfig callInvitationConfig = new ZegoUIKitPrebuiltCallInvitationConfig();
        callInvitationConfig.notifyWhenAppRunningInBackgroundOrQuit = true;
        ZegoNotificationConfig notificationConfig = new ZegoNotificationConfig();
        notificationConfig.sound = "zego_uikit_sound_call";
        notificationConfig.channelID = "CallInvitation";
        notificationConfig.channelName = "CallInvitation";
        ZegoUIKitPrebuiltCallInvitationService.init(getApplication(), appID, appSign, userID, userName,callInvitationConfig);
    }
}