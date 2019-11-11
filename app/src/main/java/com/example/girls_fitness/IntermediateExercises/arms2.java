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

public class arms2 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdg = "no";
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
        setContentView(R.layout.activity_arms2);
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
            videoIdg = bundle.getString("videoIdg");

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
                videoIdg=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdg=speaker;
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
        if(videoIdg.equals("Forearms Rotation")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.forearmsrotation);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.forearmrotation);
            txtText1.setText("FOREARMS ROTATION");
            speaker="Full Resistance Stretch";
            rohit="Weighted Arm Circles";
            this.setTitle(videoIdg);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Full Resistance Stretch")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fullresistancestretch);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdg);
            speaker="Plank To Downward Dog";
            rohit="Forearms Rotation";
            mp = MediaPlayer.create(this, R.raw.nm);
            txtText.setText(R.string.fullresistancestretch);
            txtText1.setText("FULL RESISTANCE STRETCH");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Plank To Downward Dog")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.planktodownwarddog);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdg);
            speaker="Pull And Down";
            rohit="Full Resistance Stretch";
            txtText.setText(R.string.planktodownwarddog);
            txtText1.setText("PLANK TO DOWNWARD DOG");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdg.equals("Pull And Down")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pullanddown);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.pullanddown);
            txtText1.setText("PULL AND DOWN");
            speaker="Punching";
            this.setTitle(videoIdg);
            rohit="Plank To Downward Dog";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Punching")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.punching);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.punching);
            txtText1.setText("PUNCHING");
            speaker="Shoulder Touch Plank";
            this.setTitle(videoIdg);
            rohit="Pull And Down";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Shoulder Touch Plank")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shouldertouchplank);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.shouldertouchplank);
            txtText1.setText("SHOULDER TOUCH PLANK");
            speaker="Side Plank";
            rohit="Punching";
            this.setTitle(videoIdg);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Side Plank")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sideplank);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sideplank);
            txtText1.setText("SIDE PLANK");
            speaker="Slice Cut";
            rohit="Shoulder Touch Plank";
            this.setTitle(videoIdg);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Slice Cut")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.slicecut);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.slicecut);
            txtText1.setText("SLICE CUT");
            speaker="Upper Hammering";
            rohit="Side Plank";
            this.setTitle(videoIdg);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Upper Hammering")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.upperhammering);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.upperhammering);
            txtText1.setText("UPPER HAMMERING");
            speaker="Weighted Arm Circles";
            rohit="Slice Cut";
            this.setTitle(videoIdg);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdg.equals("Weighted Arm Circles")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.weightedarmcircles);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.weightedarmcircle);
            txtText1.setText("WEIGHTED ARM CIRCLES");
            speaker="Forearms Rotation";
            rohit="Upper Hammering";
            this.setTitle(videoIdg);
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
                myNewchild.setValue(videoIdg+"shoulder beginner");
                Toast.makeText(arms2.this,"Thanks For Support", Toast.LENGTH_SHORT)
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