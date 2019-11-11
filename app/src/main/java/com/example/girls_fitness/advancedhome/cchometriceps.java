package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.arms33;

public class cchometriceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchometriceps);
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
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Forearms Sway");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Overhead Extension");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Palm Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Single Arm Torso Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Triceps Pushups With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Triceps Dips");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Triceps Dips On Floor");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Triceps Dips With Extended Legs");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","Wrist Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, arms33.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdj","ZigZag Palm Knee Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }

}
