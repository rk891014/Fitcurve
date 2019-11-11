package com.example.girls_fitness.AdvancedExercises;

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

public class arms31 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdh = "no";
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
        setContentView(R.layout.activity_arms31);
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
            videoIdh = bundle.getString("videoIdh");

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
                videoIdh=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdh=speaker;
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
        if(videoIdh.equals("Biceps pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bicepspushups);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.bicepspushups);
            txtText1.setText("FOREARMS ROTATION");
            speaker="Biceps Curls";
            rohit="Pushups With Leg On Chair";
            this.setTitle(videoIdh);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Biceps Curls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bisepscurl);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdh);
            speaker="Chest Press";
            rohit="Biceps pushups";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.bicepscurl);
            txtText1.setText("FULL RESISTANCE STRETCH");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Chest Press")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chestpress);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdh);
            speaker="Hammer Move";
            rohit="Biceps Curls";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.chestpress);
            txtText1.setText("CHEST PRESS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Hammer Move")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hammermove);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdh);
            speaker="Inverted Hand Biceps Curl";
            rohit="Chest Press";
            txtText.setText(R.string.hammermove);
            txtText1.setText("HAMMER MOVE");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdh.equals("Inverted Hand Biceps Curl")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.invertedhandbicepscurl);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.invertedhandbicepscurl);
            txtText1.setText("INVERTED HAND BICEPS CURL");
            speaker="IO Stepping With Chair";
            this.setTitle(videoIdh);
            rohit="Hammer Move";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("IO Stepping With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.iosteppingwithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.iosteppingwithchair);
            txtText1.setText("IO STEPPING WITH CHAIR");
            speaker="Lying Biceps Curls";
            this.setTitle(videoIdh);
            rohit="Inverted Hand Biceps Curl";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Lying Biceps Curls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lyingbicepscurl);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lyingbicepscurl);
            txtText1.setText("LYING BICEPS CURLS");
            speaker="Preacher Curls";
            rohit="IO Stepping With Chair";
            this.setTitle(videoIdh);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Preacher Curls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.preachercurl);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.preachercurl);
            txtText1.setText("PREACHER CURLS");
            speaker="Push Upright Curls";
            rohit="Lying Biceps Curls";
            this.setTitle(videoIdh);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Push Upright Curls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pushuprightcurl);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pushuprightcurl);
            txtText1.setText("PUSH UPRIGHT CURLS");
            speaker="Pushups With Leg On Chair";
            rohit="Preacher Curls";
            this.setTitle(videoIdh);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdh.equals("Pushups With Leg On Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pushupwithlegonchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pushupswithlegonchair);
            txtText1.setText("PUSHUPS WITH LEG ON CHAIR");
            speaker="Biceps pushups";
            rohit="Push Upright Curls";
            this.setTitle(videoIdh);
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
                myNewchild.setValue(videoIdh+"shoulder beginner");
                Toast.makeText(arms31.this,"Thanks For Support", Toast.LENGTH_SHORT)
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