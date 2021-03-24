package com.heinzawaung.linux;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ChoseFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_file);

        final EditText emailAddress = findViewById(R.id.editTextTextEmailAddress);
        final EditText message = findViewById(R.id.editMessage);
        final EditText subject = findViewById(R.id.editTextTextPersonName);
        Button sendButton = findViewById(R.id.sendMailData);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails = emailAddress.getText().toString();
                String [] mails = emails.split(",");
                String messageData = message.getText().toString();
                String subjectData = subject.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,mails);
                intent.putExtra(Intent.EXTRA_SUBJECT,subjectData);
                intent.putExtra(Intent.EXTRA_TEXT, messageData);
                intent.setType("plain/text");
                Intent intentChooser = Intent.createChooser(intent, "Chose App to Send");
                startActivity(intentChooser);
            }
        });
    }
}