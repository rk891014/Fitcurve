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

public class crunches3 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdb = "no";
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
        setContentView(R.layout.activity_crunches3);
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
            videoIdb = bundle.getString("videoIdb");

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
                videoIdb=rohit;
                onResume();
                btnSpeak.setOnClickListener(this);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdb=speaker;
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
            if(videoIdb.equals("Crunches With Leg Hold")) {
                Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cruncheswithleghold);
                video.setVideoURI(videoPath);
                video.start();
                txtText.setText(R.string.legdrop);
                txtText1.setText("CRUNCHES WITH LEG HOLD");
                speaker="Circle Crunches";
                rohit="X Man Crunches";
                this.setTitle(videoIdb);
                imageView2.setImageResource(R.drawable.crunches);
                imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Circle Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.circlecrunches);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdb);
                speaker="Butterfly Situps";
                rohit="Crunches With Leg Hold";
            txtText.setText(R.string.cruncheswithlegonchair);
            txtText1.setText("CIRCLE CRUNCHES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
            }else if(videoIdb.equals("Butterfly Situps")) {
                Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.butterflysitups);
                video.setVideoURI(videoPath);
                video.start();
                this.setTitle(videoIdb);
                speaker="Heels To Heaven";
                rohit="Circle Crunches";
                txtText.setText(R.string.singlekneetochest);
                txtText1.setText("BUTTERFLY SITUPS");
                imageView2.setImageResource(R.drawable.crunches);
                imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdb.equals("Heels To Heaven")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.heelstoheaven);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.legroll);
            txtText1.setText("HEELS TO HEAVEN");
                speaker="Leg Raises";
                this.setTitle(videoIdb);
                rohit="Butterfly Situps";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Leg Raises")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legraises);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crunches);
            txtText1.setText("LEG RAISES");
                speaker="Downbelly Stretch";
                this.setTitle(videoIdb);
                rohit="Heels To Heaven";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Downbelly Stretch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.downbellystretch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetochestcrunches);
            txtText1.setText("DOWNBELLY STRETCH");
                speaker="IO Stepping On Hands";
                rohit="Leg Raises";
                this.setTitle(videoIdb);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("IO Stepping On Hands")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.iosteppingwithhand);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.abbike);
            txtText1.setText("IO STEPPING ON HANDS");
                speaker="Knee To Elbow Plank";
                rohit="Downbelly Stretch";
                this.setTitle(videoIdb);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Knee To Elbow Plank")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneetoelbowplank);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.plankjack);
            txtText1.setText("KNEE TO ELBOW PLANK");
                speaker="Reverse Crunches";
                rohit="IO Stepping On Hands";
                this.setTitle(videoIdb);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Reverse Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reversecrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.toetouchcrunch);
            txtText1.setText("REVERSE CRUNCHES");
                speaker="Torso Lift";
                rohit="Knee To Elbow Plank";
                this.setTitle(videoIdb);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("Torso Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.torsolift);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.windmill);
            txtText1.setText("TORSO LIFT");
                speaker="X Man Crunches";
                rohit="Reverse Crunches";
                this.setTitle(videoIdb);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdb.equals("X Man Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.xmencrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.windmill);
            txtText1.setText("X MAN CRUNCHES");
                speaker="Crunches With Leg Hold";
                rohit="Torso Lift";
                this.setTitle(videoIdb);
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
                myNewchild.setValue(videoIdb+"   ABS ADVANCED");
                Toast.makeText(crunches3.this,"Thanks For Support", Toast.LENGTH_SHORT)
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