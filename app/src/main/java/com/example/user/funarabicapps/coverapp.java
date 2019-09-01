package com.example.user.funarabicapps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class coverapp extends AppCompatActivity {
    int status = 0;
    MediaPlayer mp;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_coverapp);

        mp = MediaPlayer.create(getBaseContext(), R.raw.background);
        if (status == 0 && !mp.isPlaying()) {
            mp.setLooping(true);
            mp.start();
        }
        final Button category = (Button) findViewById(R.id.buttonmula);
        category.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mp.stop();
                status = 1;
                imageview.setImageResource(R.drawable.vol_off);
                Intent myIntent = new Intent(coverapp.this, Register.class);
                startActivity(myIntent);
            }
        });
    }

}
