package com.heinzawaung.linux;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Activity {
    private static final int CREATE_FILE = 1;

    private RadioGroup radioGroup;
    private TextView textChose;
    private Button goButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.radioGroup);
        textChose = findViewById(R.id.textViewChose);
        goButton = findViewById(R.id.buttonGo);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonPhoneCall:
                        Intent intent = new Intent(Main.this,CallPhone.class);
                        startActivity(intent);
                        break;
                    case R.id.radioButtonSendEmail:
                        Intent sendEmailIntent = new Intent(Main.this, ChoseFile.class);
                        startActivity(sendEmailIntent);
                        break;
                    case R.id.radioButtonSendDrawable:
                        Uri uri = Uri.parse("android.resource://com.heinzawaung.linux/drawable/" + R.drawable.ic_launcher_background);
                        Intent intentOne = new Intent(Intent.ACTION_SEND);
                        intentOne.putExtra(Intent.EXTRA_STREAM,uri);
                        intentOne.putExtra(Intent.EXTRA_TEXT,"This is put extra Stream");
                        intentOne.setType("image/*");
                        startActivity(intentOne);
                        break;
                    case R.id.radioButtonVideoPlay:
                        Intent videoIntent = new Intent(Main.this, TestVideoView.class);
                        startActivity(videoIntent);
                        break;
                    case R.id.radioButtonInternalPicture:
                        sendInternalData();
                        break;
                }
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void sendInternalData() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        Intent createChooser = Intent.createChooser(intent,"File");
        Uri data = createChooser.getData();
        intent.putExtra(Intent.ACTION_SEND,data);
        startActivity(createChooser);

    }

}