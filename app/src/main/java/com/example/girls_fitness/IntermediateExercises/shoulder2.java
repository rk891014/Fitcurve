package com.example.girls_fitness.IntermediateExercises;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.girls_fitness.R;
import com.firebase.client.Firebase;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.QUEUE_ADD;

public class shoulder2 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdd = "no";
    public TextView txtText;
    public ImageView imageView2,imageView3,imageView4,imageView5,imageView6;
    public TextView txtText1;
    public String speaker;
    public String rohit;
    MediaPlayer mp;
    VideoView video;
    Boolean isClicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtText = (TextView) findViewById(R.id.txtText);
        txtText1 = (TextView) findViewById(R.id.txtText1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            videoIdd = bundle.getString("videoIdd");

        }


        video=(VideoView)findViewById(R.id.videoView);
        myEditText = (EditText) findViewById(R.id.editText2);
        myKeyValue = (EditText) findViewById(R.id.editText1);
        myApplyBt = (Button) findViewById(R.id.button);
        next=(Button) findViewById(R.id.next);
        previous = (Button)findViewById(R.id.previous);

        tts = new TextToSpeech(this, this);
        mp = MediaPlayer.create(this, R.raw.nm);
        btnSpeak = (Button) findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!isClicked) {
                    v.setBackgroundResource(R.drawable.mute);
                    isClicked = true;
                    speakOut();
                    mp.setLooping(true);
                } else {
                    v.setBackgroundResource(R.drawable.speaker);
                    tts.stop();
                    mp.stop();
                    isClicked = false;
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous();
                videoIdd=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdd=speaker;
                onResume();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        VideoView video = (VideoView) findViewById(R.id.videoView);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        if(videoIdd.equals("Back And Forth Hand")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backandforthhand);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backandforthhand);
            txtText1.setText("BACK AND FORTH HAND");
            speaker="Back Extension";
            rohit="Weighted Arm Circles";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Back Extension")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backextension);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdd);
            speaker="Bent Overrow";
            rohit="Back And Forth Hand";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.backextension);
            txtText1.setText("BACK EXTENSION");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Bent Overrow")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bentoverrow);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdd);
            speaker="Duck Swim";
            rohit="Back Extension";
            txtText.setText(R.string.bentoverrows);
            txtText1.setText("BENT OVERROWS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdd.equals("Duck Swim")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.duckswim);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.duckswim);
            txtText1.setText("DUCK SWIM");
            speaker="Gripped Bent Overrows";
            this.setTitle(videoIdd);
            rohit="Bent Overrow";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Gripped Bent Overrows")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.grippedbentoverrows);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.grippedbentoverrows);
            txtText1.setText("GRIPPED BENT OVERROWS");
            speaker="Half Rainbow arch";
            this.setTitle(videoIdd);
            rohit="Duck Swim";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Half Rainbow arch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.halfrainbowarch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.halfrainbowarch);
            txtText1.setText("HALF RAINBOW ARCH");
            speaker="Knee To Chin Lift";
            rohit="Gripped Bent Overrows";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Knee To Chin Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneetochinlift);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetochinlift);
            txtText1.setText("KNEE TO CHIN LIFT");
            speaker="Scorpian Move";
            rohit="Half Rainbow arch";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Scorpian Move")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.scorpianmove);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.scorpianmove);
            txtText1.setText("SCORPIAN MOVE");
            speaker="Standing Wingfly";
            rohit="Knee To Chin Lift";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Standing Wingfly")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingwingfly);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingwingfly);
            txtText1.setText("STANDING WINGFLY");
            speaker="Weighted Arm Circles";
            rohit="Scorpian Move";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdd.equals("Weighted Arm Circles")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.weightedarmcircles);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.weightedarmcircle);
            txtText1.setText("WEIGHTED ARM CIRCLES");
            speaker="Back And Forth Hand";
            rohit="Standing Wingfly";
            this.setTitle(videoIdd);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }

        // button on click event
//        btnSpeak.setOnClickListener(new View.OnClickListener() {
//
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View arg0) {
//                speakOut();
//
//            }
//
//
//        });



        Firebase.setAndroidContext(this);
        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);


        myFireBase = new Firebase("https://girls-fitness-2f107.firebaseio.com/Users" + DeviceID);
        myApplyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myKeyValueData = myKeyValue.getText().toString();
                myStringData = myEditText.getText().toString();
                Firebase myNewchild = myFireBase.child(myKeyValueData);
                myNewchild.setValue(myStringData);
                myNewchild.setValue(videoIdd+"shoulder beginner");
                Toast.makeText(shoulder2.this,"Thanks For Support", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onPause() {
        super.onPause();
        tts.stop();
        mp.stop();
        isClicked=false;
    }



    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null ) {
            tts.stop();
            mp.stop();
            mp.release();
            tts.shutdown();
        }
        super.onDestroy();
    }

    private void next() {
        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        video.startAnimation(animSlideDown);
        txtText1.startAnimation(animSlideDown);
        txtText.startAnimation(animSlideDown);
        imageView2.startAnimation(animSlideDown);
        imageView3.startAnimation(animSlideDown);
        imageView4.startAnimation(animSlideDown);
        imageView5.startAnimation(animSlideDown);
        imageView6.startAnimation(animSlideDown);
        tts.stop();
        mp.stop();
        btnSpeak.setBackgroundResource(R.drawable.speaker);


    }

    private void previous() {
        Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
        video.startAnimation(animSlideDown);
        txtText1.startAnimation(animSlideDown);
        isClicked = false;
        txtText.startAnimation(animSlideDown);
        imageView2.startAnimation(animSlideDown);
        imageView3.startAnimation(animSlideDown);
        imageView4.startAnimation(animSlideDown);
        imageView5.startAnimation(animSlideDown);
        imageView6.startAnimation(animSlideDown);
        tts.stop();
        mp.stop();
        btnSpeak.setBackgroundResource(R.drawable.speaker);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut() {
        String text = txtText.getText().toString();
        int result = tts.setLanguage(Locale.ENGLISH);
        tts.setPitch((float)1);
        tts.setSpeechRate((float).8);
        tts.speak(text, QUEUE_ADD, null,null);
        tts.playSilentUtterance(3000, TextToSpeech.QUEUE_ADD,null);
        mp = MediaPlayer.create(this, R.raw.nm);
        mp.start();
    }

    @Override
    public void onInit(int status) {
        if(status != TextToSpeech.ERROR) {
            tts.setLanguage(Locale.ENGLISH);
            tts.setPitch((float)1);
            tts.setSpeechRate((float).8);
        }
    }

}