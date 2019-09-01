package com.example.user.funarabicapps;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;

public class TransportVoice extends AppCompatActivity {

    Button button;
    public int currentimageindex=0;
    Animation shake;
    MediaPlayer mp;
    Resources resources;
    private int[] IMAGE_IDS = {R.drawable.definisikatagantinamketigasatu, R.drawable.definisikatagantinamaketigadua, R.drawable.maksuddiaia, R.drawable.maksudmereka, R.drawable.maksudbaginda,
            R.drawable.maksudbeliau,};

    private int[] rawIds = {
            R.raw.definisikatagantinamaketigasatu, R.raw.definisikatagantinamaketigadua, R.raw.dia, R.raw.mereka,
            R.raw.baginda, R.raw.beliau,
    };

    private String[] TextIds1 = {" Thoirah = طائرة ", " Darajatun = دراجة ", " Hafilah = حافلة ", " Sayyarah = سيارة ", " Halikubter = هليكوبتر ",
            " Shahinah = شاحنة ", " DarajatuNariah = دراجة نارية ", " Safinah = سفينة ", " Qhawasah = غواصة ",
            " Qhitor = قطار ",};

    private String[] TextIds2 = {" Kapal Terbang/Aeroplane ", " Basikal/Bicycle ", " Bas/Bus ", " Kereta/Car ", " Helikopter/Helicopter ",
            " Lori/Lorry ", "Motosikal/Motorcycle ", " Kapal/Ship ", " Kapal Selam/Submarine ",
            " Keretapi/Train ",};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport_voice);
        resources = getResources();

        final ImageView imageview = (ImageView)findViewById(R.id.ImageViewPreview);
        final int position = getIntent().getExtras().getInt("imgPos");
        mp = MediaPlayer.create(getBaseContext(), rawIds[position]);
        mp.start();
        imageview.setImageResource(IMAGE_IDS[position]);

        final TextView textview1 = (TextView)findViewById(R.id.textView2);
        Animation inFromRight1 = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight1.setDuration(500);
        textview1.startAnimation(inFromRight1);
        textview1.setText(TextIds1[position]);

        final TextView textview2 = (TextView)findViewById(R.id.textView3);
        Animation inFromRight2 = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight2.setDuration(500);
        textview2.startAnimation(inFromRight2);
        textview2.setText(TextIds2[position]);


        currentimageindex = position;

        //image click
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mp.stop();
                mp = MediaPlayer.create(getBaseContext(), rawIds[currentimageindex]);
                mp.start();
                imageview.startAnimation(shake);
            }
        });


        button = (Button) findViewById(R.id.forward_btn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if ((IMAGE_IDS.length) > (currentimageindex + 1)) {
                    mp.stop();
                    Animation inFromRight = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, +1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight.setDuration(500);
                    imageview.startAnimation(inFromRight);
                    imageview.setImageResource(IMAGE_IDS[currentimageindex + 1]);

                    // Text incoming
                    Animation inFromRight1 = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, +1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight1.setDuration(500);
                    textview1.startAnimation(inFromRight1);
                    textview1.setText(TextIds1[currentimageindex + 1]);

                    // Text incoming
                    Animation inFromRight2 = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, +1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight2.setDuration(500);
                    textview2.startAnimation(inFromRight2);
                    textview2.setText(TextIds2[currentimageindex + 1]);

                    currentimageindex++;
                    mp = MediaPlayer.create(getBaseContext(), rawIds[currentimageindex]);
                    mp.start();
                }
            }

        });

        button = (Button) findViewById(R.id.backward_btn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currentimageindex >= 1) {
                    mp.stop();
                    Animation inFromLeft = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, -1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromLeft.setDuration(500);
                    imageview.startAnimation(inFromLeft);
                    imageview.setImageResource(IMAGE_IDS[currentimageindex - 1]);

                    // Text incoming
                    Animation inFromRight1 = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, +1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight1.setDuration(500);
                    textview1.startAnimation(inFromRight1);
                    textview1.setText(TextIds1[currentimageindex - 1]);

                    // Text incoming
                    Animation inFromRight2 = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, +1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight2.setDuration(500);
                    textview2.startAnimation(inFromRight2);
                    textview2.setText(TextIds2[currentimageindex - 1]);

                    currentimageindex--;
                    mp = MediaPlayer.create(getBaseContext(), rawIds[currentimageindex]);
                    mp.start();
                }
            }

        });

        button = (Button) findViewById(R.id.home_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0){
                Intent intent = new Intent(TransportVoice.this, Category.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
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
    public void onPause() {
        super.onPause();
        super.onStop();
        mp.stop();
    }
}

