package com.heinzawaung.linux;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle saveInstantState) {
        super.onCreate(saveInstantState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.slide);
        textView.setSelected(true);

        mediaPlayer = MediaPlayer.create(this,R.raw.without);
        mediaPlayer.start();

         Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    mediaPlayer.pause();
                    Intent intent = new Intent(MainActivity.this,Main.class);
                    startActivity(intent);
                }
            }
        });
         thread.start();
    }

}