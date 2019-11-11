package com.example.girls_fitness.IntermediateExercises;

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

public class legs2 extends AppCompatActivity implements TextToSpeech.OnInitListener{

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdq = "no";
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
        setContentView(R.layout.activity_legs2);
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
            videoIdq = bundle.getString("videoIdq");

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
                videoIdq=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdq=speaker;
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
        if(videoIdq.equals("Backward Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.backwardlunges);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.backwardlunges);
            txtText1.setText("BACKWARD LUNGES");
            speaker="Forward Lunges";
            rohit="Two Strokes squats";
            this.setTitle(videoIdq);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Forward Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.forwardlunges);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdq);
            speaker="Full Ballet Kick";
            rohit="Backward Lunges";
            txtText.setText(R.string.forwardlunges);
            txtText1.setText("FORWARD LUNGES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Full Ballet Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fullballetkick);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdq);
            speaker="Jumping squats";
            rohit="Forward Lunges";
            txtText.setText(R.string.fullballetkick);
            txtText1.setText("FULL BALLET KICK");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdq.equals("Jumping squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jumpingsquads);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.jumpingsquads);
            txtText1.setText("JUMPING squatS");
            speaker="Lunge Knee Hope";
            this.setTitle(videoIdq);
            rohit="Full Ballet Kick";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Lunge Knee Hope")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lungekneehope);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lungeskneehop);
            txtText1.setText("LUNGE KNEE HOPE");
            speaker="Lunges";
            this.setTitle(videoIdq);
            rohit="Jumping squats";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lunges);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.lunges);
            txtText1.setText("LUNGES");
            speaker="Mountain Climber With Chair";
            rohit="Lunge Knee Hope";
            this.setTitle(videoIdq);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Mountain Climber With Chair")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mountainclimberwithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.mountainclimber);
            txtText1.setText("MOUNTAIN CLIMBER WITH CHAIR");
            speaker="Reverse Back Stretch Lunges";
            rohit="Lunges";
            this.setTitle(videoIdq);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Reverse Back Stretch Lunges")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reversebackstretchlunges);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.reversebackstretchlunges);
            txtText1.setText("REVERSE BACK STRETCH LUNGES");
            speaker="Sumo squats";
            rohit="Mountain Climber With Chair";
            this.setTitle(videoIdq);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Sumo squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sumosquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.sumosquats);
            txtText1.setText("SUMO squatS");
            speaker="Two Strokes squats";
            rohit="Reverse Back Stretch Lunges";
            this.setTitle(videoIdq);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdq.equals("Two Strokes squats")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.twostrokesquates);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.twostrokesquads);
            txtText1.setText("TWO STROKES squatS");
            speaker="Backward Lunges";
            rohit="Sumo squats";
            this.setTitle(videoIdq);
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
                myNewchild.setValue(videoIdq+"shoulder beginner");
                Toast.makeText(legs2.this,"Thanks For Support", Toast.LENGTH_SHORT)
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
