package com.example.multisports;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    Button inplayBtn, goalBtn, goal1, goal2, goal3, goal4;
    TextView firstText, secondText, goal_1, goal_2, goal_3, goal_4, angleBtn, replayBtn;
    LinearLayout linearLayout;
    int videoTime = 0;
    int flag = 0;
    MediaController seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView videoView1 = (VideoView) findViewById(R.id.videoView1);
        VideoView videoView2 = (VideoView) findViewById(R.id.videoView2);
        angleBtn = (TextView) findViewById(R.id.ChangeAngle);
        replayBtn = (TextView) findViewById(R.id.replayBtn);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.Linear1);

        videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messi_highlights);  // Set the path of the video "messi_highlights"

//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView1);         // Link mediaController to videoView
//        videoView1.setMediaController(mediaController);    // Allow mediaController to control our videoView
//        mediaController.hide();

        linearLayout.bringToFront();
        replayBtn.bringToFront();
        angleBtn.bringToFront();

        videoView1.start();

        firstText = (TextView) findViewById(R.id.firstText);
        firstText.setVisibility(RelativeLayout.INVISIBLE);


        // Hide videoView2 when it is finished playing
        videoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView2.setVisibility(RelativeLayout.INVISIBLE);

                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText("");
            }
        });

        // videoView1 returns to InPlay
        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.messi_highlights);
                videoView1.seekTo(videoTime);
                videoView1.start();
                // mediaController.hide();
                firstText.setText(" In-Play ");
            }
        });



        // Click Change Angle Button
        angleBtn = (TextView) findViewById(R.id.ChangeAngle);

        angleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoTime = videoView1.getCurrentPosition();        // Remember current time

                firstText = (TextView) findViewById(R.id.firstText);
                firstText.setText(" Angle #1 ");

                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText(" Angle #2 ");

                videoView1.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal_angle8);
                videoView2.setVisibility(RelativeLayout.VISIBLE);
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal_angle7);

                videoView1.start();
                videoView2.start();
            }
        });


        // Click Repaly Button
        replayBtn = (TextView) findViewById(R.id.replayBtn);

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (flag == 0) {
                    secondText = (TextView) findViewById(R.id.secondText);
                    secondText.setText(" Goal #1 (Replay) ");

                    videoView2.setVisibility(RelativeLayout.VISIBLE);
                    videoView2.bringToFront();
                    secondText.bringToFront();
                    videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal1);
                    videoView2.start();

                    flag++;
                } else if (flag == 1) {
                    secondText = (TextView) findViewById(R.id.secondText);
                    secondText.setText(" Goal #2 (Replay) ");

                    videoView2.setVisibility(RelativeLayout.VISIBLE);
                    videoView2.bringToFront();
                    secondText.bringToFront();
                    videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal2);
                    videoView2.start();

                    flag++;
                } else if (flag == 2) {
                    secondText = (TextView) findViewById(R.id.secondText);
                    secondText.setText(" Goal #3 (Replay) ");

                    videoView2.setVisibility(RelativeLayout.VISIBLE);
                    videoView2.bringToFront();
                    secondText.bringToFront();
                    videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal3);
                    videoView2.start();

                    flag++;
                } else if (flag == 3){
                    secondText = (TextView) findViewById(R.id.secondText);
                    secondText.setText(" Goal #4 (Replay) ");

                    videoView2.setVisibility(RelativeLayout.VISIBLE);
                    videoView2.bringToFront();
                    secondText.bringToFront();
                    videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal4);
                    videoView2.start();

                    flag = 0;
                }
            }
        });


        // Landscape Mode
        goal_1 = (TextView) findViewById(R.id.messi_20_1);
        goal_2 = (TextView) findViewById(R.id.neymar_36_1);
        goal_3 = (TextView) findViewById(R.id.messi_76_1);
        goal_4 = (TextView) findViewById(R.id.williams_79_1);

        goal_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText(" Goal #1 (Replay) ");

                videoView2.setVisibility(RelativeLayout.VISIBLE);
                videoView2.bringToFront();
                secondText.bringToFront();
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal1);
                videoView2.start();
            }
        });

        goal_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText(" Goal #2 (Replay) ");

                videoView2.setVisibility(RelativeLayout.VISIBLE);
                videoView2.bringToFront();
                secondText.bringToFront();
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal2);
                videoView2.start();
            }
        });

        goal_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText(" Goal #3 (Replay) ");

                videoView2.setVisibility(RelativeLayout.VISIBLE);
                videoView2.bringToFront();
                secondText.bringToFront();
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal3);
                videoView2.start();
            }
        });

        goal_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondText = (TextView) findViewById(R.id.secondText);
                secondText.setText(" Goal #4 (Replay) ");

                videoView2.setVisibility(RelativeLayout.VISIBLE);
                videoView2.bringToFront();
                secondText.bringToFront();
                videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.goal4);
                videoView2.start();
            }
        });


    }
}