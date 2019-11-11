package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.crunches1;

public class bbhomeabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomeabs);
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
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Single Leg Knee To Chest");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Crunches With leg On Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Leg Drop");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Leg Roll");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Knee To Chest Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Ab Bike");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","PlankJack");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Toe Touch Crunch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, crunches1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIda","Windmill");
        i.putExtras(bundle);
        startActivity(i);
    }

}
