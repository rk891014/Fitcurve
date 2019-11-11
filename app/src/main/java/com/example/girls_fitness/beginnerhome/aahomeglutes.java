package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.glutes1;

public class aahomeglutes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomeglutes);
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
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Backbard kicking With chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Butt Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Chair Pulses");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Cross leg Point");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Donkey kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Hip Drives");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Kickback");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Modified Donkey Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","side Squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, glutes1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIds","Squats On Toes");
        i.putExtras(bundle);
        startActivity(i);
    }

}
