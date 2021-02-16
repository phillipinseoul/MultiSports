package com.example.multisports;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button inplayBtn, goalBtn, angleBtn;
    int videoTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView1 = (VideoView) findViewById(R.id.videoView1);
        VideoView videoView2 = (VideoView) findViewById(R.id.videoView2);

        videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messi_highlights);  // Set the path of the video "messi_highlights"

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView1);         // Link mediaController to videoView
        videoView1.setMediaController(mediaController);    // Allow mediaController to control our videoView
        videoView1.start();


        // Click Inplay Button
        inplayBtn = (Button) findViewById(R.id.InPlay);

        inplayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messi_highlights);
                videoView1.seekTo(videoTime);
            }
        });


        // Click Goal Replay Button
        goalBtn = (Button) findViewById(R.id.GoalReplay);

        goalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal_angle5);
                videoView2.start();
            }
        });


        // Click Change Angle Button
        angleBtn = (Button) findViewById(R.id.ChangeAngle);

        angleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoTime = videoView1.getCurrentPosition();        // Remember current time

                videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal_angle8);
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal_angle7);

                videoView1.start();
                videoView2.start();
            }
        });
    }
}