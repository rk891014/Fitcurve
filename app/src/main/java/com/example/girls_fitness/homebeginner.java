package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.beginnerhome.aahomeabs;
import com.example.girls_fitness.beginnerhome.aahomearms;
import com.example.girls_fitness.beginnerhome.aahomechest;
import com.example.girls_fitness.beginnerhome.aahomeglutes;
import com.example.girls_fitness.beginnerhome.aahomelegs;
import com.example.girls_fitness.beginnerhome.aahomeshoulder;
import com.example.girls_fitness.beginnerhome.aahomesidefat;

public class homebeginner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homebeginner);
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
        Intent i = new Intent(this, aahomeabs.class);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, aahomeshoulder.class);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, aahomearms.class);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, aahomechest.class);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, aahomelegs.class);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, aahomeglutes.class);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, aahomesidefat.class);
        startActivity(i);
    }
}
