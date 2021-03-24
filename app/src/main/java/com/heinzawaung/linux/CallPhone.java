package com.heinzawaung.linux;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CallPhone extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        final EditText editText = findViewById(R.id.editText);
        Button callPhone = findViewById(R.id.callButton);
        Button checkBill = findViewById(R.id.buttonCheckBill);
        //Change to Number Type
        editText.setInputType(InputType.TYPE_CLASS_PHONE);

        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = editText.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        checkBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = Uri.encode("#");
                String checkBalance = "*124" + code;
                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + checkBalance));
                startActivity(intent);
            }
        });

    }
}