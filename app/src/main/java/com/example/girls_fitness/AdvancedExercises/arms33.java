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

public class arms33 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdj = "no";
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
        setContentView(R.layout.activity_arms33);
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
            videoIdj = bundle.getString("videoIdj");

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
                videoIdj=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdj=speaker;
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
        if(videoIdj.equals("Forearms Sway")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.forearmssway);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.forearmssway);
            txtText1.setText("FOREARMS SWAY");
            speaker="Overhead Extension";
            rohit="ZigZag Palm Knee Pushups";
            this.setTitle(videoIdj);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Overhead Extension")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.overheadextension);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdj);
            speaker="Palm Pushups";
            rohit="Forearms Sway";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.overheadextension);
            txtText1.setText("OVERHEAD EXTENSION");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Palm Pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.palmpushups);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdj);
            speaker="Single Arm Torso Lift";
            rohit="Overhead Extension";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.palmpushups);
            txtText1.setText("PALM PUSHUPS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Single Arm Torso Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.singlearmtorsolift);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdj);
            speaker="Triceps Pushups With Chair";
            rohit="Palm Pushups";
            txtText.setText(R.string.singlearmtorsolift);
            txtText1.setText("SINGLE ARM TORSO LIFT");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdj.equals("Triceps Pushups With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tricepspushupswithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.tricepspushupswithchair);
            txtText1.setText("TRICEPS PUSHUPS WITH CHAIR");
            speaker="Triceps Dips";
            this.setTitle(videoIdj);
            rohit="Single Arm Torso Lift";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Triceps Dips")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tricepsdips);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.tricepsdips);
            txtText1.setText("TRICEPS DIPS");
            speaker="Triceps Dips On Floor";
            this.setTitle(videoIdj);
            rohit="Triceps Pushups With Chair";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Triceps Dips On Floor")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tricepsdipsonfloor);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.tricepsdipsonfloor);
            txtText1.setText("TRICEPS DIPS ON FLOOR");
            speaker="Triceps Dips With Extended Legs";
            rohit="Triceps Dips";
            this.setTitle(videoIdj);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Triceps Dips With Extended Legs")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tricepsdipswithextendedleg);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.tricepsdipswithextendedleg);
            txtText1.setText("TRICEPS DIPS WITH EXTENDED LEGS");
            speaker="Wrist Pushups";
            rohit="Triceps Dips On Floor";
            this.setTitle(videoIdj);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("Wrist Pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wristpussups);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.wristpushups);
            txtText1.setText("WRIST PUSHUPS");
            speaker="ZigZag Palm Knee Pushups";
            rohit="Triceps Dips With Extended Legs";
            this.setTitle(videoIdj);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdj.equals("ZigZag Palm Knee Pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zigzagpalmkneepushups);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.zigzagpalmkneepushups);
            txtText1.setText("ZIGZAG PALM KNEE PUSHUPS");
            speaker="Forearms Sway";
            rohit="Wrist Pushups";
            this.setTitle(videoIdj);
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
                myNewchild.setValue(videoIdj+"shoulder beginner");
                Toast.makeText(arms33.this,"Thanks For Support", Toast.LENGTH_SHORT)
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