package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.chest1;

public class aahomechest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomechest);
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
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Chest Circles");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Chest Stretch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Dynamic Chest");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Elbow Chest Expander");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Elbow Touch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Palm Touch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Pool Crossover");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Shoulder Rotation");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Straight Pulling");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, chest1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdl","Upward Pulling");
        i.putExtras(bundle);
        startActivity(i);
    }

}
