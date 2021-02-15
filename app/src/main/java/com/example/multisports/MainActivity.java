package com.example.multisports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView) findViewById(R.id.videoView1);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messi_full);  // Set the path of the video "messi_full"

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);         // Link mediaController to videoView
        videoView.setMediaController(mediaController);    // Allow mediaController to control our videoView
        videoView.start();
    }
}