package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.arms1;

public class aahomearms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomearms);
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
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Arms Circles");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Birdfly");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Both Arm Circles");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Cris Cros Hands");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Elbow Squeeze");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Elbow Push");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Overhead Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Popping Beats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","Up And Down Hands");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, arms1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdf","X Arm Swing");
        i.putExtras(bundle);
        startActivity(i);
    }

}
