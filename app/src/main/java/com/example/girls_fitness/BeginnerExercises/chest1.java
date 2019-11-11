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

public class chest1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdl = "no";
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
        setContentView(R.layout.activity_chest1);
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
            videoIdl = bundle.getString("videoIdl");

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
                videoIdl=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdl=speaker;
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
        if(videoIdl.equals("Chest Circles")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chestcircles);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.chestcircles);
            txtText1.setText("CHEST CIRCLES");
            speaker="cheststretch";
            rohit="Upward Pulling";
            this.setTitle(videoIdl);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("cheststretch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cheststretch);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdl);
            speaker="Dynamic Chest";
            rohit="Chest Circles";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.cheststretch);
            txtText1.setText("CHESTSTRETCH");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Dynamic Chest")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dynamicchest);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdl);
            speaker="Elbow Chest Expander";
            rohit="cheststretch";
            txtText.setText(R.string.dynamicchest);
            txtText1.setText("DYNAMIC CHEST");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdl.equals("Elbow Chest Expander")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elbowchestexpander);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.elbowchestexpander);
            txtText1.setText("ELBOW CHEST EXPANDER");
            speaker="Elbow Touch";
            this.setTitle(videoIdl);
            rohit="Dynamic Chest";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Elbow Touch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elbowtouch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.elbowtouch);
            txtText1.setText("ELBOW TOUCH");
            speaker="Palm Touch";
            this.setTitle(videoIdl);
            rohit="Elbow Chest Expander";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Palm Touch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.palmtouch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.palmtouch);
            txtText1.setText("PALM TOUCH");
            speaker="Pool Crossover";
            rohit="Elbow Touch";
            this.setTitle(videoIdl);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Pool Crossover")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.poolcrossover);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.poolcrossover);
            txtText1.setText("POOL CROSSOVER");
            speaker="Shoulder Rotation";
            rohit="Palm Touch";
            this.setTitle(videoIdl);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Shoulder Rotation")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shoulderrotation);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shoulderrotation);
            txtText1.setText("SHOULDER ROTATION");
            speaker="Straight Pulling";
            rohit="Pool Crossover";
            this.setTitle(videoIdl);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Straight Pulling")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.straightpulling);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.straightpulling);
            txtText1.setText("STRAIGHT PULLING");
            speaker="Upward Pulling";
            rohit="Shoulder Rotation";
            this.setTitle(videoIdl);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdl.equals("Upward Pulling")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upwardpulling);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.upwardpulling);
            txtText1.setText("UPWARD PULLING");
            speaker="Chest Circles";
            rohit="Straight Pulling";
            this.setTitle(videoIdl);
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
                myNewchild.setValue(videoIdl+"shoulder beginner");
                Toast.makeText(chest1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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