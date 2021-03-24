package com.heinzawaung.linux;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class TestVideoView extends Activity {
    private boolean play = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        Button playPause = findViewById(R.id.playPause);
        final VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.minkhant));
        videoView.requestFocus();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play = !play;
                if (play){
                    videoView.start();
                }else {
                    videoView.pause();
                }
            }
        });
    }
}