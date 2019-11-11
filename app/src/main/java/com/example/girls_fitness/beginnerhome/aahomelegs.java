package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.legs1;

public class aahomelegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomelegs);
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
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Crab Walk");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Knee Hop With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Knee Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Leg Lift With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Legs Swing");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Single Leg Knee To Chest");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Sit And Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","squats Hold");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, legs1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdp","Toes Lift");
        i.putExtras(bundle);
        startActivity(i);
    }

}
