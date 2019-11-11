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

public class shoulder3 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIde = "no";
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
        setContentView(R.layout.activity_shoulder3);
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
            videoIde = bundle.getString("videoIde");

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
                videoIde=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIde=speaker;
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
        if(videoIde.equals("Backarch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backarch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backarch);
            txtText1.setText("BACKARCH");
            speaker="Back Hand Stretch";
            rohit="Shoulder pushups";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Back Hand Stretch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backhandstretch);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIde);
            speaker="Extension With Resistance Band";
            rohit="Backarch";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.backhandstretch);
            txtText1.setText("BACK HAND STRETCH");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Extension With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.extensionwithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIde);
            speaker="Hanging Weighted Rows";
            rohit="Back Hand Stretch";
            txtText.setText(R.string.extensionwithresistanceband);
            txtText1.setText("EXTENSION WITH RESISTANCE BAND");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIde.equals("Hanging Weighted Rows")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hangingweightedrows);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.hangingweightedrows);
            txtText1.setText("HANGING WEIGHTED ROWS");
            speaker="Lie Down Rows";
            this.setTitle(videoIde);
            rohit="Extension With Resistance Band";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Lie Down Rows")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.liedownrow);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.liedownrow);
            txtText1.setText("LIE DOWN ROWS");
            speaker="Pike Shoulder Press";
            this.setTitle(videoIde);
            rohit="Hanging Weighted Rows";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Pike Shoulder Press")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pikeshoulderpress);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pikeshoulderpress);
            txtText1.setText("PIKE SHOULDER PRESS");
            speaker="Resistance Back Grip";
            rohit="Lie Down Rows";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Resistance Back Grip")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.resistancebackgrip);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.resistancebackgrip);
            txtText1.setText("RESISTANCE BACK GRIP");
            speaker="Resistance Band Rows";
            rohit="Pike Shoulder Press";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Resistance Band Rows")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.resistancebandrows);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.resistancebandrows);
            txtText1.setText("RESISTANCE BAND ROWS");
            speaker="Shoulder extension";
            rohit="Resistance Back Grip";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Shoulder extension")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shoulderextension);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shoulderextension);
            txtText1.setText("SHOULDER EXTENSION");
            speaker="Shoulder Pull With Resistance Band";
            rohit="Resistance Band Rows";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Shoulder Pull With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shoulderpullwithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shoulderpullwithresistanceband);
            txtText1.setText("SHOULDER PULL WITH RESISTANCE BAND");
            speaker="Shoulder pushups";
            rohit="Shoulder extension";
            this.setTitle(videoIde);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIde.equals("Shoulder pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shoulderpushups);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shoulderpushups);
            txtText1.setText("SHOULDER PUSHUPS");
            speaker="Backarch";
            rohit="Shoulder Pull With Resistance Band";
            this.setTitle(videoIde);
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
                myNewchild.setValue(videoIde+"shoulder beginner");
                Toast.makeText(shoulder3.this,"Thanks For Support", Toast.LENGTH_SHORT)
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