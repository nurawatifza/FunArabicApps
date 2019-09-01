package com.example.user.funarabicapps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.google.analytics.tracking.android.EasyTracker;

public class Register extends AppCompatActivity {
    int status = 0;
    MediaPlayer mp;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);


        mp = MediaPlayer.create(getBaseContext(), R.raw.background);
        if (status == 0 && !mp.isPlaying()) {
            mp.setLooping(true);
            mp.start();
        }
        imageview = (ImageView) findViewById(R.id.volume);
        imageview.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mp.isPlaying() && status == 0) {
                    mp.stop();
                    imageview.setImageResource(R.drawable.vol_off);
                    status = 1;
                } else {
                    mp = MediaPlayer.create(getBaseContext(), R.raw.background);
                    mp.isLooping();
                    mp.start();
                    imageview.setImageResource(R.drawable.soundicon);
                    status = 0;
                }
            }
        });

        final Button category = (Button) findViewById(R.id.button5);
        category.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mp.stop();
                status = 1;
                imageview.setImageResource(R.drawable.vol_off);
                Intent myIntent = new Intent(Register.this, Category.class);
                startActivity(myIntent);
            }
        });

        final Button lets_practice = (Button) findViewById(R.id.button4);
        lets_practice.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mp.stop();
                status = 1;
                imageview.setImageResource(R.drawable.vol_off);
                Intent myIntent = new Intent(Register.this, KategoriSoalan.class);
                startActivity(myIntent);
            }
        });

        final Button lets_learn = (Button) findViewById(R.id.button6);
        lets_learn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mp.stop();
                status = 1;
                imageview.setImageResource(R.drawable.vol_off);
                Intent myIntent = new Intent(Register.this, Learn.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);  // Add this method.
    }

    @Override
    public void onStop() {
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);  // Add this method.
    }

    @Override
    public void onPause(){
        super.onPause();
        mp.stop();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(!mp.isPlaying()){
            status = 0;
            imageview.setImageResource(R.drawable.vol_on);
            mp = MediaPlayer.create(getBaseContext(), R.raw.background);
            mp.setLooping(true);
            mp.start();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
