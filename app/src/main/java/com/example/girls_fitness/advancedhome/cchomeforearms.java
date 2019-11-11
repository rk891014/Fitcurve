package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.arms32;

public class cchomeforearms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomeforearms);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onclick(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Accelerating Curl");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this,arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","IO Stepping With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Prayer Pulses");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Reverse Wrist Curl");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Single Arm Torso Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Wrist Curl");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Wrist Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, arms32.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdi","Wrist Twist");
        i.putExtras(bundle);
        startActivity(i);
    }


}
