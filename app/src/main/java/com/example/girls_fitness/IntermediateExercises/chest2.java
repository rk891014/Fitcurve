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

public class chest2 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdm = "no";
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
        setContentView(R.layout.activity_chest2);
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
            videoIdm = bundle.getString("videoIdm");

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
                videoIdm=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdm=speaker;
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
        if(videoIdm.equals("Chest Stretch On Toes")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cheststretchontoes);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.cheststretchontoes);
            txtText1.setText("CHEST STRETCH ON TOES");
            speaker="First Fly Accros Head";
            rohit="Standing Chest Press Move";
            this.setTitle(videoIdm);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("First Fly Accros Head")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.firstflyacrosshead);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdm);
            speaker="Fist Flies";
            rohit="Chest Stretch On Toes";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.fistflyacrosshead);
            txtText1.setText("FIRST FLY ACCROS HEAD");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Fist Flies")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fistflies);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdm);
            speaker="Half Pushups";
            rohit="First Fly Accros Head";
            txtText.setText(R.string.fistflies);
            txtText1.setText("FIST FLIES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdm.equals("Half Pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.halfpushups);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.halfpushups);
            txtText1.setText("HALF PUSHUPS");
            speaker="Head Pullover";
            this.setTitle(videoIdm);
            rohit="Fist Flies";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Head Pullover")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.headpullover);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.headpullover);
            txtText1.setText("HEAD PULLOVER");
            speaker="Knee Pushups";
            this.setTitle(videoIdm);
            rohit="Half Pushups";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Knee Pushups")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneepushupsbeg);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneepushups);
            txtText1.setText("KNEE PUSHUPS");
            speaker="Pike Chest Press";
            rohit="Head Pullover";
            this.setTitle(videoIdm);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Pike Chest Press")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pikechestpress);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pikechestpress);
            txtText1.setText("PIKE CHEST PRESS");
            speaker="Shoulder Swing";
            rohit="Knee Pushups";
            this.setTitle(videoIdm);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Shoulder Swing")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shoulderswing);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shoulderswing);
            txtText1.setText("SHOULDER SWING");
            speaker="Single Hand Chest Press";
            rohit="Pike Chest Press";
            this.setTitle(videoIdm);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Single Hand Chest Press")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.singlehandchestpress);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.singlehandchestpress);
            txtText1.setText("SINGLE HAND CHEST PRESS");
            speaker="Standing Chest Press Move";
            rohit="Shoulder Swing";
            this.setTitle(videoIdm);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdm.equals("Standing Chest Press Move")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingchestpressmove);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingchestpressmove);
            txtText1.setText("STANDING CHEST PRESS MOVE");
            speaker="Chest Stretch On Toes";
            rohit="Single Hand Chest Press";
            this.setTitle(videoIdm);
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
                myNewchild.setValue(videoIdm+"shoulder beginner");
                Toast.makeText(chest2.this,"Thanks For Support", Toast.LENGTH_SHORT)
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