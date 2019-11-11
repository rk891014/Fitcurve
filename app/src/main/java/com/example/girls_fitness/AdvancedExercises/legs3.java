package com.example.girls_fitness.AdvancedExercises;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.example.girls_fitness.R;
import com.firebase.client.Firebase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.speech.tts.TextToSpeech;
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

import java.util.Locale;

import static android.speech.tts.TextToSpeech.QUEUE_ADD;

public class legs3 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdr = "no";
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
        setContentView(R.layout.activity_legs3);
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
            videoIdr = bundle.getString("videoIdr");

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
                videoIdr=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdr=speaker;
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
        if(videoIdr.equals("Chest Expander On Squate Pose")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chestexpanderonsquatpose);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.chestexpanderonsquatpose);
            txtText1.setText("CHEST EXPANDER ON SQUATE POSE");
            speaker="Curtsy Lunges";
            rohit="squats With Resistance Band";
            this.setTitle(videoIdr);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Curtsy Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.curtsylunges);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdr);
            speaker="Knee Jump";
            rohit="Chest Expander On Squate Pose";
            txtText.setText(R.string.curtsylunges);
            txtText1.setText("CURTSY LUNGES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Knee Jump")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneejump);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdr);
            speaker="Knee To Chest Jump";
            rohit="Curtsy Lunges";
            txtText.setText(R.string.kneejump);
            txtText1.setText("KNEE JUMP");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdr.equals("Knee To Chest Jump")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneetochestjump);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetochestjump);
            txtText1.setText("KNEE TO CHEST JUMP");
            speaker="Lunges With Chair";
            this.setTitle(videoIdr);
            rohit="Knee Jump";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Lunges With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lungeswithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lungeswithchair);
            txtText1.setText("LUNGES WITH CHAIR");
            speaker="Pop squats";
            this.setTitle(videoIdr);
            rohit="Knee To Chest Jump";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Pop squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.popsquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.popsquats);
            txtText1.setText("POP squatS");
            speaker="Resistance Backgrip";
            rohit="Lunges With Chair";
            this.setTitle(videoIdr);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Resistance Backgrip")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.resistancebackgrip);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.resistancebackgrip);
            txtText1.setText("RESISTANCE BACKGRIP");
            speaker="Side Lunges";
            rohit="Pop squats";
            this.setTitle(videoIdr);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("Side Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidelunges);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sidelunges);
            txtText1.setText("SIDE LUNGES");
            speaker="squats On Toes";
            rohit="Resistance Backgrip";
            this.setTitle(videoIdr);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("squats On Toes")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squadsontoes);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squatsontoes);
            txtText1.setText("squatS ON TOES");
            speaker="squats With Resistance Band";
            rohit="Side Lunges";
            this.setTitle(videoIdr);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdr.equals("squats With Resistance Band")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.squatswithresistanceband);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.squatwithresistanceband);
            txtText1.setText("squatS WITH RESISTANCE BAND");
            speaker="Chest Expander On Squate Pose";
            rohit="squats On Toes";
            this.setTitle(videoIdr);
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
                myNewchild.setValue(videoIdr+"shoulder beginner");
                Toast.makeText(legs3.this,"Thanks For Support", Toast.LENGTH_SHORT)
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
