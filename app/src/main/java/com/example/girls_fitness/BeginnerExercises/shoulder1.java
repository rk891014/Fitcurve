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

public class shoulder1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdc = "no";
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
        setContentView(R.layout.activity_shoulder1);
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
            videoIdc = bundle.getString("videoIdc");

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
                videoIdc=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdc=speaker;
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
        if(videoIdc.equals("Back Pulling")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backpulling);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backpulling);
            txtText1.setText("BACK PULLING");
            speaker="Bird Fly";
            rohit="Standing Scorpian Move";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.chest4);
            imageView5.setImageResource(R.drawable.shoulder4);
            imageView6.setImageResource(R.drawable.forearms4);
        }else if(videoIdc.equals("Bird Fly")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birdfly);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdc);
            speaker="Circle Pulls";
            rohit="Back Pulling";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.birdfly);
            txtText1.setText("BIRD FLY");
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.collar4);
            imageView5.setImageResource(R.drawable.shoulder4);
            imageView6.setImageResource(R.drawable.forearms4);
        }else if(videoIdc.equals("Circle Pulls")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.circlepulls);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdc);
            speaker="Cris Cros Hands";
            rohit="Bird Fly";
            txtText.setText(R.string.circlepulls);
            txtText1.setText("CIRCLE PULLS");
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.forearms4);
            imageView5.setImageResource(R.drawable.chest4);
            imageView6.setImageResource(R.drawable.shoulder4);

        }else if(videoIdc.equals("Cris Cros Hands")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.criscroshands);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.criscrosshands);
            txtText1.setText("CRIS CROS HANDS");
            speaker="Floating Hands";
            this.setTitle(videoIdc);
            rohit="Circle Pulls";
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.triceps4);
            imageView5.setImageResource(R.drawable.chest4);
            imageView6.setImageResource(R.drawable.shoulder4);
        }else if(videoIdc.equals("Floating Hands")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.floatinghands);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.floatinghands);
            txtText1.setText("FLOATING HANDS");
            speaker="Full Hand Rotation";
            this.setTitle(videoIdc);
            rohit="Cris Cros Hands";
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.chest4);
            imageView5.setImageResource(R.drawable.biseps4);
            imageView6.setImageResource(R.drawable.forearms4);
        }else if(videoIdc.equals("Full Hand Rotation")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fullhandrotation);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.fullhandrotation);
            txtText1.setText("FULL HAND ROTATION");
            speaker="Lying Wing Fly";
            rohit="Floating Hands";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.shoulder4);
            imageView5.setImageResource(R.drawable.forearms4);
            imageView6.setImageResource(R.drawable.biseps4);
        }else if(videoIdc.equals("Lying Wing Fly")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lyingwingfly);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lyingwingfly);
            txtText1.setText("LYING WING FLY");
            speaker="Prayer Pulses";
            rohit="Full Hand Rotation";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.collar4);
            imageView5.setImageResource(R.drawable.chest4);
            imageView6.setImageResource(R.drawable.backthigh4);
        }else if(videoIdc.equals("Prayer Pulses")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.prayerpulses);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.prayerpulses);
            txtText1.setText("PLAYER PULSES");
            speaker="Shoulder Move";
            rohit="Lying Wing Fly";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.calf4);
            imageView6.setImageResource(R.drawable.backthigh4);
        }else if(videoIdc.equals("Shoulder Move")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shouldermove);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shouldermove);
            txtText1.setText("SHOULDER MOVE");
            speaker="Standing Scorpian Move";
            rohit="Prayer Pulses";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.calf4);
            imageView6.setImageResource(R.drawable.backthigh4);
        }else if(videoIdc.equals("Standing Scorpian Move")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingscorpianmove);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingscorpianmove);
            txtText1.setText("STANDING SCORPIAN MOVE");
            speaker="Back Pulling";
            rohit="Shoulder Move";
            this.setTitle(videoIdc);
            imageView2.setImageResource(R.drawable.back4);
            imageView3.setImageResource(R.drawable.shoulder5);
            imageView4.setImageResource(R.drawable.glutes4);
            imageView5.setImageResource(R.drawable.calf4);
            imageView6.setImageResource(R.drawable.backthigh4);
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
                myNewchild.setValue(videoIdc+"shoulder beginner");
                Toast.makeText(shoulder1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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