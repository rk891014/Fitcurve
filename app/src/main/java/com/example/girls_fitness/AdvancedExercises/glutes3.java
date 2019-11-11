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

public class glutes3 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdu = "no";
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
        setContentView(R.layout.activity_glutes3);
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
            videoIdu = bundle.getString("videoIdu");

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
                videoIdu=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdu=speaker;
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
        if(videoIdu.equals("Bottom Leg Lift")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bottomleglift);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.bottomleglift);
            txtText1.setText("BOTTOM LEG LIFT");
            speaker="Butt Bridge With Chair";
            rohit="Standing Ballet Kick";
            this.setTitle(videoIdu);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Butt Bridge With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.buttbridgewithchair);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdu);
            speaker="Donkey Kick With Resistance Band";
            rohit="Bottom Leg Lift";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.buttbridgewithchair);
            txtText1.setText("BUTT BRIDGE WITH CHAIR");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Donkey Kick With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.donkeykickwithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdu);
            speaker="Fire Hydrant";
            rohit="Butt Bridge With Chair";
            txtText.setText(R.string.donkeykickwithresistanceband);
            txtText1.setText("DONKEY KICK WITH RESISTANCE BAND");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdu.equals("Fire Hydrant")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.firehydrant);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.firehydrant);
            txtText1.setText("FIRE HYDRANT");
            speaker="Halfballet Kick";
            this.setTitle(videoIdu);
            rohit="Donkey Kick With Resistance Band";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Halfballet Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.halfballetkick);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.halfballetkick);
            txtText1.setText("HALFBALLET KICK");
            speaker="Jumping Sumosquats";
            this.setTitle(videoIdu);
            rohit="Fire Hydrant";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Jumping Sumosquats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumpingsumosquats);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.jumpingsumosquats);
            txtText1.setText("JUMPING SUMOSQUATS");
            speaker="Pop Squats";
            rohit="Halfballet Kick";
            this.setTitle(videoIdu);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Pop Squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.popsquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.popsquats);
            txtText1.setText("POP SQUATS");
            speaker="Soletapping With Resistance Band";
            rohit="Jumping Sumosquats";
            this.setTitle(videoIdu);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Soletapping With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.soletappingwithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.soletappingwithresistanceband);
            txtText1.setText("SOLETAPPING WITH RESISTANCE BAND");
            speaker="squats With Resistance Band";
            rohit="Pop Squats";
            this.setTitle(videoIdu);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("squats With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squatswithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squatswithresistanceband);
            txtText1.setText("SQUATS WITH RESISTANCE BAND");
            speaker="Standing Ballet Kick";
            rohit="Soletapping With Resistance Band";
            this.setTitle(videoIdu);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdu.equals("Standing Ballet Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.standingballetkick);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingballetkick);
            txtText1.setText("STANDING BALLET KICK");
            speaker="Bottom Leg Lift";
            rohit="squats With Resistance Band";
            this.setTitle(videoIdu);
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
                myNewchild.setValue(videoIdu+"shoulder beginner");
                Toast.makeText(glutes3.this,"Thanks For Support", Toast.LENGTH_SHORT)
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