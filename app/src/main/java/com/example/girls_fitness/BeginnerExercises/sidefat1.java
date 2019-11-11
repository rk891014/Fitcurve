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

public class sidefat1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdaa = "no";
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
        setContentView(R.layout.activity_sidefat1);
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
            videoIdaa = bundle.getString("videoIdaa");

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
                videoIdaa=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdaa=speaker;
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
        if(videoIdaa.equals("Ankle Touch Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ankletouchtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.ankletouchtwist);
            txtText1.setText("ANKLE TOUCH TWIST");
            speaker="Arms Over Knee";
            rohit="Toe Touching";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Arms Over Knee")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.armsoverknee);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdaa);
            speaker="Back Pack Kid Dance";
            rohit="Ankle Touch Twist";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.armsoverknee);
            txtText1.setText("ARMS OVER KNEE");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Back Pack Kid Dance")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backpackkiddance);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdaa);
            speaker="Can Can Abs";
            rohit="Arms Over Knee";
            txtText.setText(R.string.backpackkiddance);
            txtText1.setText("Back Pack Kid Dance");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Can Can Abs")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cancanabs);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.cancanabs);
            txtText1.setText("CAN CAN ABS");
            speaker="Cross Body Crunches";
            this.setTitle(videoIdaa);
            rohit="Back Pack Kid Dance";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Cross Body Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crossbodycrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crossbodycrunches);
            txtText1.setText("CROSS BODY CRUNCHES");
            speaker="Elbow Drop";
            this.setTitle(videoIdaa);
            rohit="Can Can Abs";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Elbow Drop")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.elbowdrop);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.elbowdrop);
            txtText1.setText("ELBOW DROP");
            speaker="Jumping Twist";
            rohit="Cross Body Crunches";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Jumping Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumpingtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.jumpingtwist);
            txtText1.setText("JUMPING TWIST");
            speaker="Lying Butt Twist";
            rohit="Elbow Drop";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Lying Butt Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lyingbutttwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lyingbutttwist);
            txtText1.setText("LYING BUTT TWIST");
            speaker="Reaching Oblique Crunches";
            rohit="Jumping Twist";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Reaching Oblique Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reachingobliquecrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.reachingabliquetwist);
            txtText1.setText("REACHING OBLIQUE CRUNCHES");
            speaker="Side Elbow Twist";
            rohit="Lying Butt Twist";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Side Elbow Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidealbowtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sideelbowtwist);
            txtText1.setText("SIDE Elbow TWIST");
            speaker="Side To Side Drop";
            rohit="Reaching Oblique Crunches";
            this.setTitle(videoIdaa);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdaa.equals("Side To Side Drop")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidetosidedrop);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.sidetosidedrop);
        txtText1.setText("SIDE TO SIDE DROP");
        speaker="Standing Bicycle Crunches";
        this.setTitle(videoIdaa);
        rohit="Side Elbow Twist";
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdaa.equals("Standing Bicycle Crunches")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingbicyclecrunches);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.standingbicyclecrunches);
        txtText1.setText("STANDING BICYCLE CRUNCHES");
        speaker="Toe Touching";
        this.setTitle(videoIdaa);
        rohit="Side To Side Drop";
        imageView2.setImageResource(R.drawable.crunches);
        imageView4.setImageResource(R.drawable.crunches);
    }else if(videoIdaa.equals("Toe Touching")) {
        Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.toetouching);
        video.setVideoURI(videoPath);
        video.start();
        txtText.setText(R.string.toetouching);
        txtText1.setText("TOE TOUCHING");
        speaker="Ankle Touch Twist";
        rohit="Standing Bicycle Crunches";
        this.setTitle(videoIdaa);
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
                myNewchild.setValue(videoIdaa+"shoulder beginner");
                Toast.makeText(sidefat1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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