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

public class sidefat3 extends AppCompatActivity implements
        TextToSpeech.OnInitListener {

    EditText myEditText,myKeyValue;
    Button myApplyBt;
    String myStringData,myKeyValueData;
    Firebase myFireBase;
    private TextToSpeech tts;
    private Button btnSpeak;
    public Button next;
    public Button previous;
    String videoIdac = "no";
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
        setContentView(R.layout.activity_sidefat3);
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
            videoIdac = bundle.getString("videoIdac");

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
                videoIdac=rohit;
                onResume();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                videoIdac=speaker;
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
        if(videoIdac.equals("Cross knee Plank")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crosskneeplank);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.armraisesplank);
            txtText1.setText("CROSS KNEE PLANK");
            speaker="Glutes Touch Twist";
            rohit="Side Crunches";
            this.setTitle(videoIdac);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Glutes Touch Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.glutestouchtwist);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdac);
            speaker="Hip Lift Pulses";
            rohit="Cross knee Plank";
            txtText.setText(R.string.armsoverknee);
            txtText1.setText("GLUTES TOUCH TWIST");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Hip Lift Pulses")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hipliftpulses);
            video.setVideoURI(videoPath);
            video.start();
            this.setTitle(videoIdac);
            speaker="Knee Swing";
            rohit="Glutes Touch Twist";
            txtText.setText(R.string.cancanabs);
            txtText1.setText("HIP LIFT PULSES");
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);

        }else if(videoIdac.equals("Knee Swing")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kneeswing);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crossbodycrunches);
            txtText1.setText("KNEE SWING");
            speaker="Pilates Side Hip Raises";
            this.setTitle(videoIdac);
            rohit="Hip Lift Pulses";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Pilates Side Hip Raises")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pilatessidehipraises);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.crosspunch);
            txtText1.setText("PILATES SIDE HIP RAISES");
            speaker="Pull And Twist";
            this.setTitle(videoIdac);
            rohit="Knee Swing";
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Pull And Twist")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pullandtwist);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.headdrop);
            txtText1.setText("PULL AND TWIST");
            speaker="Push And Knee Kick";
            rohit="Pilates Side Hip Raises";
            this.setTitle(videoIdac);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Push And Knee Kick")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.pushupandkneekickwithchair);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.heeltouch);
            txtText1.setText("PUSH AND KNEE KICK");
            speaker="Rainbow Swoops";
            rohit="Pull And Twist";
            this.setTitle(videoIdac);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Rainbow Swoops")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.rainbowswoops);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.kneetoelbowtwist);
            txtText1.setText("RAINBOW SWOOPS");
            speaker="Reverse Table Top";
            rohit="Push And Knee Kick";
            this.setTitle(videoIdac);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Reverse Table Top")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.reversetabletop);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.reclinedobliquetwist);
            txtText1.setText("REVERSE TABLE TOP");
            speaker="Side Crunches";
            rohit="Rainbow Swoops";
            this.setTitle(videoIdac);
            imageView2.setImageResource(R.drawable.crunches);
            imageView4.setImageResource(R.drawable.crunches);
        }else if(videoIdac.equals("Side Crunches")) {
            Uri videoPath = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sidecrunches);
            video.setVideoURI(videoPath);
            video.start();
            txtText.setText(R.string.standingabbike);
            txtText1.setText("SIDE CRUNCHES");
            speaker="Cross knee Plank";
            rohit="Reverse Table Top";
            this.setTitle(videoIdac);
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
                myNewchild.setValue(videoIdac+"shoulder beginner");
                Toast.makeText(sidefat3.this,"Thanks For Support", Toast.LENGTH_SHORT)
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