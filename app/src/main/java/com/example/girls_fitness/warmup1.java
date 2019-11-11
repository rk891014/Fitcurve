package com.example.girls_fitness;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
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

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.firebase.client.Firebase;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.QUEUE_ADD;

public class warmup1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdo = "no";
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
        setContentView(R.layout.activity_warmup1);
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
            videoIdo = bundle.getString("videoIdo");

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
                videoIdo=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdo=speaker;
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
        if(videoIdo.equals("Anklesway Left")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ankleswayleft);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backpulling);
            txtText1.setText("ANKLESWAY LEFT");
            speaker="Armscissors";
            rohit="Xmenjump";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Armscissors")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.armscissors);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdo);
            speaker="Full Lie Burpee";
            rohit="Anklesway Left";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.birdfly);
            txtText1.setText("ARMSCISSORS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Full Lie Burpee")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fulllieburpee);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdo);
            speaker="High Stepping";
            rohit="Armscissors";
            txtText.setText(R.string.circlepulls);
            txtText1.setText("FULL LIE BURPEE");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdo.equals("High Stepping")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.highstepping);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.criscrosshands);
            txtText1.setText("HIGH STEPPING");
            speaker="Hiproll";
            this.setTitle(videoIdo);
            rohit="Full Lie Burpee";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Hiproll")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hiproll);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.floatinghands);
            txtText1.setText("HIPROLL");
            speaker="Jogging";
            this.setTitle(videoIdo);
            rohit="High Stepping";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Jogging")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jogging);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.fullhandrotation);
            txtText1.setText("JOGGING");
            speaker="Jumping Jack";
            rohit="Hiproll";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Jumping Jack")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumpingjack);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lyingwingfly);
            txtText1.setText("JUMPING JACK");
            speaker="Jumping Twist";
            rohit="Jogging";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Jumping Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumpingtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.prayerpulses);
            txtText1.setText("JUMPING TWIST");
            speaker="Laptap";
            rohit="Jumping Jack";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Laptap")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.laptap);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shouldermove);
            txtText1.setText("LAPTAP");
            speaker="Skipping Without Rope";
            rohit="Jumping Twist";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Skipping Without Rope")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.skippingwithoutrope);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingscorpianmove);
            txtText1.setText("SKIPPING WITHOUT ROPE");
            speaker="Stairs Jumping";
            rohit="Laptap";
            this.setTitle(videoIdo);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdo.equals("Stairs Jumping")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.stairsjumping);
        video.setVideoURI(videoPath);
        video.start();
        this.setTitle(videoIdo);
        speaker="Stairs Jumping With Both Leg";
        rohit="Skipping Without Rope";
        mp = MediaPlayer.create(this, R.raw.nm);
        txtText.setText(R.string.cheststretch);
        txtText1.setText("STAIRS JUMPING");
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdo.equals("Stairs Jumping With Both Leg")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.stairsjumpingwithbothleg);
        video.setVideoURI(videoPath);
        video.start();
        this.setTitle(videoIdo);
        speaker="Stepping High";
        rohit="Stairs Jumping";
        txtText.setText(R.string.dynamicchest);
        txtText1.setText("STAIRS JUMPING WITH BOTH LEG");
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);

    }else if(videoIdo.equals("Stepping High")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.steppinghigh);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.elbowchestexpander);
        txtText1.setText("STEPPING HIGH");
        speaker="Unilateral Jump";
        this.setTitle(videoIdo);
        rohit="Stairs Jumping With Both Leg";
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdo.equals("Unilateral Jump")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.unilateraljump);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.elbowtouch);
        txtText1.setText("UNILATERAL JUMP");
        speaker="ankleswayright";
        this.setTitle(videoIdo);
        rohit="Stepping High";
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdo.equals("ankleswayright")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ankleswayright);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.palmtouch);
        txtText1.setText("ANKLESWAYRIGHT");
        speaker="Xmenjump";
        rohit="Unilateral Jump";
        this.setTitle(videoIdo);
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdo.equals("Xmenjump")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.xmenjump);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.poolcrossover);
        txtText1.setText("X-MENJUMP");
        speaker="Anklesway Left";
        rohit="ankleswayright";
        this.setTitle(videoIdo);
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
                myNewchild.setValue(videoIdo+"shoulder beginner");
                Toast.makeText(warmup1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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