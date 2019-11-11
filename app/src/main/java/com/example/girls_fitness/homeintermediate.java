package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.intermediatehome.bbhomeabs;
import com.example.girls_fitness.intermediatehome.bbhomearms;
import com.example.girls_fitness.intermediatehome.bbhomechest;
import com.example.girls_fitness.intermediatehome.bbhomeglutes;
import com.example.girls_fitness.intermediatehome.bbhomelegs;
import com.example.girls_fitness.intermediatehome.bbhomeshoulder;
import com.example.girls_fitness.intermediatehome.bbhomesidefat;

public class homeintermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeintermediate);
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
        Intent i = new Intent(this, bbhomeabs.class);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, bbhomeshoulder.class);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, bbhomearms.class);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, bbhomechest.class);
        startActivity(i);
    }

    public void onclick8(View view)
    {
        Intent i = new Intent(this, bbhomelegs.class);
        startActivity(i);
    }

    public void onclick10(View view)
    {
        Intent i = new Intent(this, bbhomeglutes.class);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, bbhomesidefat.class);
        startActivity(i);
    }
}
