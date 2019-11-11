package com.example.girls_fitness.BeginnerExercises;

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

public class Crunches extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoId = "no";
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
        setContentView(R.layout.activity_crunches);
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
            videoId = bundle.getString("videoId");

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
                videoId=rohit;
                onResume();

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoId=speaker;
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
        if(videoId.equals("Abs Cycling")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.abscycling);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.abscycling);
            txtText1.setText("ABS CYCLING");
            speaker="Donkey Kick with chair";
            rohit="Vcrunches With Chair";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.calf4);
            imageView6.setImageResource(R.drawable.backthigh4);
        }else if(videoId.equals("Donkey Kick with chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.donkeykickwithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.donkeykickwithchair);
            txtText1.setText("DONKEY KICK WITH CHAIR");
            speaker="Flutter Kicks";
            rohit="Abs Cycling";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.backthigh4);
            imageView6.setImageResource(R.drawable.calf4);
        }else if(videoId.equals("Flutter Kicks")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.flutterkicks);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.flutterkicks);
            txtText1.setText("FLUTTER KICKS");
            speaker="Leg Scissors";
            rohit="Donkey Kick with chair";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.frontthigh4);
            imageView5.setImageResource(R.drawable.glutes4);
            imageView6.setImageResource(R.drawable.calf4);
        }else if(videoId.equals("Leg Scissors")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legscissors);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legscissors);
            txtText1.setText("LEG SCISSORS");
            speaker="Mountain Climber";
            rohit="Flutter Kicks";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.calf4);
            imageView5.setImageResource(R.drawable.backthigh4);
            imageView6.setImageResource(R.drawable.glutes4);
        }else if(videoId.equals("Mountain Climber")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mountainclimber);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.mountainclimber);
            txtText1.setText("MOUNTAIN CLIMBER");
            speaker="Pilates Leg Pulls";
            rohit="Leg Scissors";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.shoulder4);
            imageView5.setImageResource(R.drawable.backthigh4);
            imageView6.setImageResource(R.drawable.forearms4);
        }else if(videoId.equals("Pilates Leg Pulls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pilateslegpulls);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pilateslegpulls);
            txtText1.setText("PILATES LEG PULLS");
            speaker="Pilates Toe Taps";
            rohit="Mountain Climber";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.frontthigh4);
            imageView5.setImageResource(R.drawable.biseps4);
            imageView6.setImageResource(R.drawable.glutes4);
        }else if(videoId.equals("Pilates Toe Taps")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pilatestoetaps);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pilatestoetap);
            txtText1.setText("PILATES TOE TAPS");
            speaker="Reverse Ab Bike";
            rohit="Pilates Leg Pulls";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.backthigh4);
            imageView6.setImageResource(R.drawable.calf4);
        }else if(videoId.equals("Reverse Ab Bike")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reverseabbike);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.reverseabbike);
            txtText1.setText("REVERSE AB BIKE");
            speaker="Stomach Crunches";
            rohit="Pilates Toe Taps";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.backthigh4);
            imageView6.setImageResource(R.drawable.calf4);
        }else if(videoId.equals("Stomach Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.stomachcrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.stomachcrunches);
            txtText1.setText("STOMACH CRUNCHES");
            speaker="Vcrunches With Chair";
            rohit="Reverse Ab Bike";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.back4);
            imageView5.setImageResource(R.drawable.frontthigh4);
            imageView6.setImageResource(R.drawable.shoulder5);
        }else if(videoId.equals("Vcrunches With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vcruncheswithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.vcrunchonchair);
            txtText1.setText("VCRUNCH ON CHAIR");
            speaker="Abs Cycling";
            rohit="Stomach Crunches";
            this.setTitle(videoId);
            imageView2.setImageResource(R.drawable.abs4);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.frontthigh4);
            imageView6.setImageResource(R.drawable.shoulder5);
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
                myNewchild.setValue(videoId+"   ABS beginner");
                Toast.makeText(Crunches.this,"Thanks For Support", Toast.LENGTH_SHORT)
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