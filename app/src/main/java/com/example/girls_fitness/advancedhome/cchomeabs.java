package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.crunches3;

public class cchomeabs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomeabs);
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
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Crunches With Leg Hold");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Circle Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Butterfly Situps");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Heels To Heaven");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Leg Raises");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Downbelly Stretch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","IO Stepping On Hands");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Knee To Elbow Plank");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Reverse Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","Torso Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, crunches3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdb","X Man Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
}
