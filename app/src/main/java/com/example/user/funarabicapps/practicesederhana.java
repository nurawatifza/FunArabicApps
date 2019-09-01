package com.example.user.funarabicapps;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.analytics.tracking.android.EasyTracker;

import java.util.Random;

public class practicesederhana extends AppCompatActivity {

    Button button;
    ImageView image1, image2, image3, image4;
    MediaPlayer mp;
    Animation shake, shake_right, animZoomIn, animZoomIn2, animZoomIn3, animZoomIn4;
    private int[] RandomSet = {-1, -1, -1, -1};
    Random Rnd = null, RndAnswer = null;
    int alphabet, question, answer, value = -1;


    private int[] CHAR_IDS = {R.drawable.puansiti, R.drawable.tiga, R.drawable.kerbau, R.drawable.empat,
    };

    private String[] TextIds1 = {"1. Sila pilih yang mana satu kata nama khas bagi kategori manusia.",
            "2. Terdapat berapa kategori dalam kata ganti nama ?",
            "3. Sila pilih yang mana satu kata nama am bagi kategori haiwan.",
            "4. Terdapat berapa kategori dalam kata nama am dan kata nama khas?"
    };


    private int[] replyIds = {R.raw.succcessful, R.raw.succcessful, R.raw.succcessful, R.raw.succcessful,
            R.raw.succcessful, R.raw.succcessful, R.raw.succcessful, R.raw.succcessful,
            R.raw.succcessful, R.raw.succcessful, R.raw.succcessful, R.raw.succcessful,
            R.raw.succcessful, R.raw.succcessful, R.raw.succcessful, R.raw.succcessful};

    private int[] failIds = {R.raw.fail, R.raw.fail, R.raw.fail, R.raw.fail,
            R.raw.fail, R.raw.fail, R.raw.fail, R.raw.fail,
            R.raw.fail, R.raw.fail, R.raw.fail, R.raw.fail,
            R.raw.fail, R.raw.fail, R.raw.fail, R.raw.fail};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_practicesederhana);
        // Show the Up button in the action bar.

        // display characters
        displayChars();
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        //shake_right = AnimationUtils.loadAnimation(this, R.anim.shake);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_lt);
        animZoomIn2 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_lb);
        animZoomIn3 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_rt);
        animZoomIn4 = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_rb);

        animZoomIn.setAnimationListener(new AnimationListener() {
            //@Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            // @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            //@Override
            public void onAnimationEnd(Animation animation) {
                // pass the intent to switch to other activity
                displayChars();
            }
        });
        animZoomIn2.setAnimationListener(new AnimationListener() {
            //@Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            // @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            //@Override
            public void onAnimationEnd(Animation animation) {
                // pass the intent to switch to other activity
                displayChars();
            }
        });
        animZoomIn3.setAnimationListener(new AnimationListener() {
            //@Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            // @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            //@Override
            public void onAnimationEnd(Animation animation) {
                // pass the intent to switch to other activity
                displayChars();
            }
        });
        animZoomIn4.setAnimationListener(new AnimationListener() {
            //@Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }

            // @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            //@Override
            public void onAnimationEnd(Animation animation) {
                // pass the intent to switch to other activity
                displayChars();
            }
        });

        image1 = (ImageView) findViewById(R.id.lefttop2);
        image2 = (ImageView) findViewById(R.id.righttop2);
        image3 = (ImageView) findViewById(R.id.leftbottom2);
        image4 = (ImageView) findViewById(R.id.rightbottom2);


        //Image Click Listener
        OnClickListener mGlobalListener = new OnClickListener() {

            @Override
            public void onClick(View v) {
                RndAnswer = new Random();
                int ans = RndAnswer.nextInt(7);
                switch (v.getId()) {
                    case R.id.lefttop2:
                        // do your stuff for btn1
                        if (answer == 0) {
                            mp = MediaPlayer.create(getBaseContext(), replyIds[ans]);
                            mp.start();
                            // SystemClock.sleep(1000);
                            findViewById(R.id.lefttop2).startAnimation(animZoomIn);
                            clearRandomSet();
                        } else {
                            mp = MediaPlayer.create(getBaseContext(), failIds[question]);
                            mp.start();
                            findViewById(R.id.lefttop2).startAnimation(shake);

                        }

                        break;
                    case R.id.leftbottom2:
                        // do your stuff for btn2
                        if (answer == 2) {
                            mp = MediaPlayer.create(getBaseContext(), replyIds[ans]);
                            mp.start();
                            //SystemClock.sleep(1000);
                            findViewById(R.id.leftbottom).startAnimation(animZoomIn2);
                            clearRandomSet();
                        } else {
                            mp = MediaPlayer.create(getBaseContext(), failIds[question]);
                            mp.start();
                            findViewById(R.id.leftbottom).startAnimation(shake);
                        }
                        break;
                    case R.id.righttop1:
                        // do your stuff for btn2
                        if (answer == 1) {
                            mp = MediaPlayer.create(getBaseContext(), replyIds[ans]);
                            mp.start();
                            // SystemClock.sleep(1000);
                            findViewById(R.id.righttop1).startAnimation(animZoomIn3);
                            clearRandomSet();
                        } else {
                            mp = MediaPlayer.create(getBaseContext(), failIds[question]);
                            mp.start();
                            findViewById(R.id.righttop1).startAnimation(shake);

                        }
                        break;
                    case R.id.rightbottom1:
                        // do your stuff for btn2
                        if (answer == 3) {
                            mp = MediaPlayer.create(getBaseContext(), replyIds[ans]);
                            mp.start();
                            //SystemClock.sleep(1000);
                            findViewById(R.id.rightbottom1).startAnimation(animZoomIn4);
                            clearRandomSet();
                        } else {
                            mp = MediaPlayer.create(getBaseContext(), failIds[question]);
                            mp.start();
                            findViewById(R.id.rightbottom1).startAnimation(shake);

                        }
                        break;
                    default:
                        break;
                }
            }
        };

        image1.setOnClickListener(mGlobalListener);
        image2.setOnClickListener(mGlobalListener);
        image3.setOnClickListener(mGlobalListener);
        image4.setOnClickListener(mGlobalListener);


        //Home button
        button = (Button) findViewById(R.id.homepractice2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(practicesederhana.this, Register.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        // Refresh button
        button = (Button) findViewById(R.id.arrowpractice2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Clear random Set
                mp.stop();
                clearRandomSet();
                displayChars();
            }
        });
    }

    public void displayChars() {
        for (int i = 0; i < 4; i++) {
            Rnd = new Random();
            alphabet = Rnd.nextInt(16);
            //check for duplicate random number
            if (i == 0) {
                add(i, alphabet);
                value = Rnd.nextInt(4);
            } else {
                if (DuplicateFound(alphabet)) {
                    --i;
                    continue;
                } else
                    add(i, alphabet);
            }

            if (i == value) {
                final TextView textview1 = (TextView) findViewById(R.id.textViewpractice2);
                Animation inFromRight1 = new TranslateAnimation(
                        Animation.RELATIVE_TO_PARENT, +1.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f,
                        Animation.RELATIVE_TO_PARENT, 0.0f);
                inFromRight1.setDuration(500);
                textview1.startAnimation(inFromRight1);
                textview1.setText(TextIds1[alphabet]);
                question = alphabet;
                answer = i;
            }

            switch (i) {
                case 0:
                    final ImageView lefttop = (ImageView) findViewById(R.id.lefttop1);
                    Animation inFromTop = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, -1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromTop.setDuration(500);
                    lefttop.startAnimation(inFromTop);
                    lefttop.setImageResource(CHAR_IDS[alphabet]);

                case 1:
                    final ImageView righttop = (ImageView) findViewById(R.id.righttop2);
                    Animation inFromRight = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromRight.setDuration(500);
                    righttop.startAnimation(inFromRight);
                    righttop.setImageResource(CHAR_IDS[alphabet]);

                case 2:
                    final ImageView leftbottom = (ImageView) findViewById(R.id.leftbottom2);
                    Animation inFromLeft = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, -1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromLeft.setDuration(500);
                    leftbottom.startAnimation(inFromLeft);
                    leftbottom.setImageResource(CHAR_IDS[alphabet]);

                case 3:
                    final ImageView rightbottom = (ImageView) findViewById(R.id.rightbottom2);
                    Animation inFromBottom = new TranslateAnimation(
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f,
                            Animation.RELATIVE_TO_PARENT, 1.0f,
                            Animation.RELATIVE_TO_PARENT, 0.0f);
                    inFromBottom.setDuration(500);
                    rightbottom.startAnimation(inFromBottom);
                    rightbottom.setImageResource(CHAR_IDS[alphabet]);

                default:
                    break;
            }
        }
    }

    public void add(int value, int random) {
        RandomSet[value] = random;
    }

    public boolean DuplicateFound(int value) {
        for (int j = 0; j < 4; j++) {
            if (RandomSet[j] == value)
                return true;
        }
        return false;
    }

    public void clearRandomSet() {
        for (int j = 0; j < 4; j++)
            RandomSet[j] = -1;
    }

    /**
     * Set up the {@link ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
