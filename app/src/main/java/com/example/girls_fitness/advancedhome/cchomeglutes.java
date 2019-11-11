package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.glutes3;

public class cchomeglutes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomeglutes);
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
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Bottom Leg Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Butt Bridge With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Donkey Kick With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Fire Hydrant");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Halfballet Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Jumping Sumosquats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Pop Squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Soletapping With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","squats With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, glutes3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdu","Standing Ballet Kick");
        i.putExtras(bundle);
        startActivity(i);
    }

}
