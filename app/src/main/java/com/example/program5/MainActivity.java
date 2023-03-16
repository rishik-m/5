package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play,reset,  pause, forward, rewind, stop;
    MediaPlayer mediaPlayer,mediaPlayer1 ;
    int starttime = 0;
    int stoptime = 0;
    int forwardtime = 5000;
    int backwardtime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        pause = findViewById(R.id.pause);
        forward = findViewById(R.id.forward);
        rewind = findViewById(R.id.rewind);
        reset = findViewById(R.id.reset);
        stop = findViewById(R.id.stop);





        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "playing media now",Toast.LENGTH_SHORT).show();
                mediaPlayer =  MediaPlayer.create(MainActivity.this, R.raw.rain);
                //mediaPlayer1 =  MediaPlayer.create(MainActivity.this, R.raw.rain);
                mediaPlayer.start();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "pausing media now",Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "reset media now",Toast.LENGTH_SHORT).show();

                mediaPlayer.seekTo(starttime);
                mediaPlayer.start();
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "fowarding media now",Toast.LENGTH_SHORT).show();

                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stoptime = mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                } }
        });

        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "rewinding media now",Toast.LENGTH_SHORT).show();

                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos-backwardtime) >= 0){
                    mediaPlayer.seekTo(currentpos-backwardtime);
                } }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "stopping media now",Toast.LENGTH_SHORT).show();
                mediaPlayer.stop();
                //mediaPlayer =  mediaPlayer1;
            }
        });


    }
}
