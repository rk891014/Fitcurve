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

public class arms1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdf = "no";
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
        setContentView(R.layout.activity_arms1);
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
            videoIdf = bundle.getString("videoIdf");

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
                videoIdf=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdf=speaker;
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
        if(videoIdf.equals("Arms Circles")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.armcircles);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.armcircle);
            txtText1.setText("ARMS circles");
            speaker="Birdfly";
            rohit="X Arm Swing";
            this.setTitle(videoIdf);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Birdfly")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birdfly);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdf);
            speaker="Both Arm Circles";
            rohit="Arms Circles";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.birdfly);
            txtText1.setText("BIRDFLY");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Both Arm Circles")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.botharmcircles);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdf);
            speaker="Cris Cros Hands";
            rohit="Birdfly";
            txtText.setText(R.string.botharmcircles);
            txtText1.setText("BOTH ARM CIRCLES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdf.equals("Cris Cros Hands")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.criscroshands);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.criscroshands);
            txtText1.setText("CRIS CROS HANDS");
            speaker="Elbow Squeeze";
            this.setTitle(videoIdf);
            rohit="Both Arm Circles";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Elbow Squeeze")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elbowsqueez);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.elbowsqueez);
            txtText1.setText("ELBOW SQUEEZE");
            speaker="Elbow Push";
            this.setTitle(videoIdf);
            rohit="Cris Cros Hands";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Elbow Push")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elbowpush);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.elbowpush);
            txtText1.setText("ELBOW PUSH");
            speaker="Overhead Press";
            rohit="Elbow Squeeze";
            this.setTitle(videoIdf);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Overhead Press")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.overheadpress);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.overheadpress);
            txtText1.setText("OVERHEAD PRESS");
            speaker="Popping Beats";
            rohit="Elbow Push";
            this.setTitle(videoIdf);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Popping Beats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.popingbeats);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.popingbeats);
            txtText1.setText("POPPING BEATS");
            speaker="Up And Down Hands";
            rohit="Overhead Press";
            this.setTitle(videoIdf);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("Up And Down Hands")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upanddownhands);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.upanddownhands);
            txtText1.setText("UP AND DOWN HANDS");
            speaker="X Arm Swing";
            rohit="Popping Beats";
            this.setTitle(videoIdf);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdf.equals("X Arm Swing")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.xarmswing);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.xarmswing);
            txtText1.setText("X ARM SWING");
            speaker="Arms Circles";
            rohit="Up And Down Hands";
            this.setTitle(videoIdf);
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
                myNewchild.setValue(videoIdf+"shoulder beginner");
                Toast.makeText(arms1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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