package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.advancedhome.cchomeabs;
import com.example.girls_fitness.advancedhome.cchomebiseps;
import com.example.girls_fitness.advancedhome.cchomechest;
import com.example.girls_fitness.advancedhome.cchomeforearms;
import com.example.girls_fitness.advancedhome.cchomeglutes;
import com.example.girls_fitness.advancedhome.cchomelegs;
import com.example.girls_fitness.advancedhome.cchomeshoulder;
import com.example.girls_fitness.advancedhome.cchomesidefat;
import com.example.girls_fitness.advancedhome.cchometriceps;

public class homeadvanced extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeadvanced);
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
        Intent i = new Intent(this, cchomeabs.class);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, cchomeshoulder.class);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, cchomebiseps.class);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, cchomechest.class);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, cchometriceps.class);
        startActivity(i);
    }

    public void onclick7(View view)
    {
        Intent i = new Intent(this, cchomeforearms.class);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, cchomelegs.class);
        startActivity(i);
    }

    public void onclick10(View view)
    {
        Intent i = new Intent(this, cchomeglutes.class);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, cchomesidefat.class);
        startActivity(i);
    }
}
