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

public class glutes1 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIds = "no";
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
        setContentView(R.layout.activity_glutes1);
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
            videoIds = bundle.getString("videoIds");

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
                videoIds=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIds=speaker;
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
        if(videoIds.equals("Backbard kicking With chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backwardkickingwithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backwardkickwithchair);
            txtText1.setText("BACKBARD KICKING WITH CHAIR");
            speaker="Butt Kick";
            rohit="Squats On Toes";
            this.setTitle(videoIds);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Butt Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.buttkick);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIds);
            speaker="Chair Pulses";
            rohit="Backbard kicking With chair";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.buttkick);
            txtText1.setText("BUTT KICK");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Chair Pulses")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chairpulses);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIds);
            speaker="Cross leg Point";
            rohit="Butt Kick";
            txtText.setText(R.string.chairpulses);
            txtText1.setText("CHAIR PULSES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIds.equals("Cross leg Point")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crosslegpoint);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crosslegpoint);
            txtText1.setText("CROSS LEG POINT");
            speaker="Donkey kick";
            this.setTitle(videoIds);
            rohit="Chair Pulses";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Donkey kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.donkeykick);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.donkeykick);
            txtText1.setText("DONKEY KICK");
            speaker="Hip Drives";
            this.setTitle(videoIds);
            rohit="Cross leg Point";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Hip Drives")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hipdrives);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.hipdrives);
            txtText1.setText("HIP DRIVES");
            speaker="Kickback";
            rohit="Donkey kick";
            this.setTitle(videoIds);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Kickback")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kickback);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kickback);
            txtText1.setText("KICKBACK");
            speaker="Modified Donkey Kick";
            rohit="Hip Drives";
            this.setTitle(videoIds);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Modified Donkey Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.modifieddonkeykick);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.modifieddonkeykick);
            txtText1.setText("MODIFIED DONKEY KICK");
            speaker="side Squats";
            rohit="Kickback";
            this.setTitle(videoIds);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("side Squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidesquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sidesquats);
            txtText1.setText("SIDE SQUATS");
            speaker="Squats On Toes";
            rohit="Modified Donkey Kick";
            this.setTitle(videoIds);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIds.equals("Squats On Toes")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squadsontoes);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squatsontoes);
            txtText1.setText("SQUATS ON TOES");
            speaker="Backbard kicking With chair";
            rohit="side Squats";
            this.setTitle(videoIds);
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
                myNewchild.setValue(videoIds+"shoulder beginner");
                Toast.makeText(glutes1.this,"Thanks For Support", Toast.LENGTH_SHORT)
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