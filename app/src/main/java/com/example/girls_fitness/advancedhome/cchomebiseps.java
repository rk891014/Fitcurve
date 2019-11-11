package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.arms31;

public class cchomebiseps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomebiseps);
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
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Biceps pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this,arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Biceps Curls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Chest Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Hammer Move");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Inverted Hand Biceps Curl");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","IO Stepping With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Lying Biceps Curls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Preacher Curls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Push Upright Curls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, arms31.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdh","Pushups With Leg On Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
   

}
