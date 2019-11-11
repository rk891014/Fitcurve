package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.glutes2;

public class bbhomeglutes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomeglutes);
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
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Cross Knee Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Dead Lift Squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Donkey Kick With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Hip Lift Leg Raises");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","IO Squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Leg Wing");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","One Legged Hip Thrust");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Side Squats With Resistance band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Sit Hit");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, glutes2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdt","Top Leg Circle");
        i.putExtras(bundle);
        startActivity(i);
    }

}
