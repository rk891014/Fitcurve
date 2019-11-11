package com.example.girls_fitness.BeginnerExercises;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.example.girls_fitness.R;
import com.firebase.client.Firebase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.speech.tts.TextToSpeech;
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

import java.util.Locale;

import static android.speech.tts.TextToSpeech.QUEUE_ADD;

public class legs1 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdp = "no";
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
        setContentView(R.layout.activity_legs1);
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
            videoIdp = bundle.getString("videoIdp");

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
                videoIdp=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdp=speaker;
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
        if(videoIdp.equals("Crab Walk")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crabwalk);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crabwalk);
            txtText1.setText("CRAB WALK");
            speaker="Knee Hop With Chair";
            rohit="Toes Lift";
            this.setTitle(videoIdp);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Knee Hop With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneehopwithchair);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdp);
            speaker="Knee Lift";
            rohit="Crab Walk";
            txtText.setText(R.string.kneehopwithchair);
            txtText1.setText("KNEE HOP WITH CHAIR");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Knee Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneelift);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdp);
            speaker="Leg Lift With Resistance Band";
            rohit="Knee Hop With Chair";
            txtText.setText(R.string.kneelift);
            txtText1.setText("KNEE LIFT");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdp.equals("Leg Lift With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legliftwithresistaqnceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legliftwithresistanceband);
            txtText1.setText("LEG LIFT WITH RESISTANCE BAND");
            speaker="Legs Swing";
            this.setTitle(videoIdp);
            rohit="Knee Lift";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Legs Swing")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legsswing);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legswing);
            txtText1.setText("LEGS SWING");
            speaker="Single Leg Knee To Chest";
            this.setTitle(videoIdp);
            rohit="Leg Lift With Resistance Band";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Single Leg Knee To Chest")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.singlelegkneetochest);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.singlelegkneetochest);
            txtText1.setText("SINGLE LEG KNEE TO CHEST");
            speaker="Sit And Kick";
            rohit="Legs Swing";
            this.setTitle(videoIdp);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Sit And Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sitandkicks);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sitandkick);
            txtText1.setText("SIT AND KICK");
            speaker="squats";
            rohit="Single Leg Knee To Chest";
            this.setTitle(videoIdp);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squats);
            txtText1.setText("SQUATS");
            speaker="squats Hold";
            rohit="Sit And Kick";
            this.setTitle(videoIdp);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("squats Hold")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squathold);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squathold);
            txtText1.setText("SQUATS HOLD");
            speaker="Toes Lift";
            rohit="squats";
            this.setTitle(videoIdp);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdp.equals("Toes Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toeslift);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.toeslift);
            txtText1.setText("TOES LIFT");
            speaker="Crab Walk";
            rohit="squats Hold";
            this.setTitle(videoIdp);
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
                myNewchild.setValue(videoIdp+"shoulder beginner");
                Toast.makeText(legs1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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
