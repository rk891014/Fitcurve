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

public class glutes2 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdt = "no";
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
        setContentView(R.layout.activity_glutes2);
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
            videoIdt = bundle.getString("videoIdt");

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
                videoIdt=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdt=speaker;
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
        if(videoIdt.equals("Cross Knee Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crosskneelift);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crosskneelift);
            txtText1.setText("CROSS KNEE LIFT");
            speaker="Dead Lift Squats";
            rohit="Top Leg Circle";
            this.setTitle(videoIdt);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Dead Lift Squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.deadliftsquats);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdt);
            speaker="Donkey Kick With Chair";
            rohit="Cross Knee Lift";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.deadliftsquats);
            txtText1.setText("DEAD LIFT SQUATS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Donkey Kick With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.donkeykickwithchair);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdt);
            speaker="Hip Lift Leg Raises";
            rohit="Dead Lift Squats";
            txtText.setText(R.string.donkeykickwithchair);
            txtText1.setText("DONKEY KICK WITH CHAIR");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdt.equals("Hip Lift Leg Raises")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hipliftlegraises);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.hipliftlegraises);
            txtText1.setText("HIP LIFT LEG RAISES");
            speaker="IO Squats";
            this.setTitle(videoIdt);
            rohit="Donkey Kick With Chair";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("IO Squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.iosquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.iosquats);
            txtText1.setText("IO SQUATS");
            speaker="Leg SSwing";
            this.setTitle(videoIdt);
            rohit="Hip Lift Leg Raises";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Leg Swing")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legsswing);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legswing);
            txtText1.setText("LEG Swing");
            speaker="One Legged Hip Thrust";
            rohit="IO Squats";
            this.setTitle(videoIdt);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("One Legged Hip Thrust")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.oneleggedhipthrust);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.oneleggedhipthrust);
            txtText1.setText("ONE LEGGED HIP THRUST");
            speaker="Side Squats With Resistance band";
            rohit="Leg Swing";
            this.setTitle(videoIdt);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Side Squats With Resistance band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidesquatwithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sidesquatswithresistance);
            txtText1.setText("SIDE SQUATS WITH RESISTANCE BAND");
            speaker="Sit Hit";
            rohit="One Legged Hip Thrust";
            this.setTitle(videoIdt);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Sit Hit")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sithit);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sithit);
            txtText1.setText("SIT HIT");
            speaker="Top Leg Circle";
            rohit="Side Squats With Resistance band";
            this.setTitle(videoIdt);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdt.equals("Top Leg Circle")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toplegcircle);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.toplegcircle);
            txtText1.setText("TOP LEG CIRCLE");
            speaker="Cross Knee Lift";
            rohit="Sit Hit";
            this.setTitle(videoIdt);
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
                myNewchild.setValue(videoIdt+"shoulder beginner");
                Toast.makeText(glutes2.this,"Thanks For Support", Toast.LENGTH_SHORT)
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