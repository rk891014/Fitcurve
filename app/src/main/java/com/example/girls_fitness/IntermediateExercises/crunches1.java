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

public class crunches1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIda = "no";
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
        setContentView(R.layout.activity_crunches1);
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
            videoIda = bundle.getString("videoIda");

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
                videoIda=rohit;
                onResume();
                btnSpeak.setOnClickListener(this);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIda=speaker;
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
        if(videoIda.equals("Single Leg Knee To Chest")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.singlelegkneetochest);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.singlekneetochest);
            txtText1.setText("SINGLE LEG KNEE TO CHEST");
            speaker="Crunches With leg On Chair";
            rohit="Windmill";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Crunches With leg On Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cruncheswithlegonchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.cruncheswithlegonchair);
            txtText1.setText("CRUNCHES WITH LEG ON CHAIR");
            speaker="Leg Drop";
            rohit="Single Leg Knee To Chest";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Leg Drop")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legdrop);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legdrop);
            txtText1.setText("LEG DROP");
            speaker="Leg Roll";
            rohit="Crunches With leg On Chair";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Leg Roll")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legroll);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legroll);
            txtText1.setText("LEG ROLL");
            speaker="Crunches";
            rohit="Leg Drop";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crunches);
            txtText1.setText("CRUNCHES");
            speaker="Knee To Chest Crunches";
            rohit="Leg Roll";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Knee To Chest Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneetochest);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetochestcrunches);
            txtText1.setText("KNEE TO CHEST CRUNCHES");
            speaker="absbike";
            rohit="Crunches";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("absbike")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.absbike);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.abbike);
            txtText1.setText("AB BIKE");
            speaker="PlankJack";
            rohit="Knee To Chest Crunches";
            this.setTitle(videoIda);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("PlankJack")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.plankjack);
            video.setVideoURI(videoPath);
            video.start();
            speaker="Toe Touch Crunch";
            rohit="absbike";
            this.setTitle(videoIda);
            txtText.setText(R.string.plankjack);
            txtText1.setText("PLANKJACK");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Toe Touch Crunch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toetouchcrunch);
            video.setVideoURI(videoPath);
            video.start();
            speaker="Windmill";
            rohit="PlankJack";
            this.setTitle(videoIda);
            txtText.setText(R.string.toetouchcrunch);
            txtText1.setText("TOE TOUCH CRUNCH");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIda.equals("Windmill")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.windmill);
            video.setVideoURI(videoPath);
            video.start();
            speaker="Single Leg Knee To Chest";
            rohit="Toe Touch Crunch";
            this.setTitle(videoIda);
            txtText.setText(R.string.windmill);
            txtText1.setText("WINDMILL");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }

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
                myNewchild.setValue(videoIda+"   ABS INTERMEDIATE");
                Toast.makeText(crunches1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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