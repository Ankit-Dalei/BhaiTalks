package com.example.bhaitalks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class HomeActivity extends AppCompatActivity {
    EditText edt;
    TextView tdt;
    ZegoSendCallInvitationButton video_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edt=(EditText) findViewById(R.id.editTextText);
        tdt=(TextView) findViewById(R.id.textView5);
        video_button=(ZegoSendCallInvitationButton) findViewById(R.id.viedo);
        String uid=getIntent().getStringExtra("uid");
        tdt.setText("Hello"+uid);

        edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String tuid=edt.getText().toString().trim();
                setVideocall(tuid);
            }
        });
    }
    void  setVideocall(String targetUserName){
        video_button.setIsVideoCall(true);
        video_button.setResourceID("zego_uikit_call");
        video_button.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserName)));
    }
}