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

public class sidefat2 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdab = "no";
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
        setContentView(R.layout.activity_sidefat2);
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
            videoIdab = bundle.getString("videoIdab");

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
                videoIdab=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdab=speaker;
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
        if(videoIdab.equals("Arm Raises Plank")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.armraisesplank);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.armraisesplank);
            txtText1.setText("ARM RAISES PLANK");
            speaker="Arms Over Knee";
            rohit="Standing Ab Bike";
            this.setTitle(videoIdab);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Arms Over Knee")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.armsoverknee);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdab);
            speaker="Can Can Abs";
            rohit="Arm Raises Plank";
            txtText.setText(R.string.armsoverknee);
            txtText1.setText("ARMS OVER KNEE");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Can Can Abs")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cancanabs);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdab);
            speaker="Cross Body Crunches";
            rohit="Arms Over Knee";
            txtText.setText(R.string.cancanabs);
            txtText1.setText("CAN CAN ABS");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdab.equals("Cross Body Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crossbodycrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crossbodycrunches);
            txtText1.setText("CROSS BODY CRUNCHES");
            speaker="Cross Punch";
            this.setTitle(videoIdab);
            rohit="Can Can Abs";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Cross Punch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crosspunch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crosspunch);
            txtText1.setText("CROSS PUNCH");
            speaker="Head Drop";
            this.setTitle(videoIdab);
            rohit="Cross Body Crunches";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Head Drop")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.headdrop);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.headdrop);
            txtText1.setText("HEAD DROP");
            speaker="Heel Touch";
            rohit="Cross Punch";
            this.setTitle(videoIdab);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Heel Touch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.heeltouch);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.heeltouch);
            txtText1.setText("HEEL TOUCH");
            speaker="Knee To Elbow Twist";
            rohit="Head Drop";
            this.setTitle(videoIdab);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Knee To Elbow Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneetoelbowtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetoelbowtwist);
            txtText1.setText("KNEE TO ELBOW TWIST");
            speaker="Reclined Oblique Twist";
            rohit="Heel Touch";
            this.setTitle(videoIdab);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Reclined Oblique Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reclinedobliquetwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.reclinedobliquetwist);
            txtText1.setText("RECLINED OBLIQUE TWIST");
            speaker="Standing Ab Bike";
            rohit="Knee To Elbow Twist";
            this.setTitle(videoIdab);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdab.equals("Standing Ab Bike")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingabbike);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingabbike);
            txtText1.setText("STANDING AB BIKE");
            speaker="Arm Raises Plank";
            rohit="Reclined Oblique Twist";
            this.setTitle(videoIdab);
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
                myNewchild.setValue(videoIdab+"shoulder beginner");
                Toast.makeText(sidefat2.this,"Thanks For Support", Toast.LENGTH_SHORT)
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