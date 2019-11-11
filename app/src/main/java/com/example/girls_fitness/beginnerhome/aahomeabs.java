package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.BeginnerExercises.Crunches;
import com.example.girls_fitness.R;

public class aahomeabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomeabs);
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
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Abs Cycling");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Donkey Kick with chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Flutter Kicks");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Leg Scissors");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Mountain Climber");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Pilates Leg Pulls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Pilates Toe Taps");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Reverse Ab Bike");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Stomach Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, Crunches.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoId","Vcrunches With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }

}
