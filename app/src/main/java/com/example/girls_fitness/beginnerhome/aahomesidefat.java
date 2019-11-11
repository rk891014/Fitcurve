package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.sidefat1;

public class aahomesidefat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomesidefat);
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
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Ankle Touch Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Arms Over Knee");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Back Pack Kid Dance");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Can Can Abs");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Cross Body Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Elbow Drop");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Jumping Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Lying Butt Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Reaching Oblique Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Side Elbow Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Side To Side Drop");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Standing Bicycle Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick12(View view)
    {
        Intent i = new Intent(this, sidefat1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdaa","Toe Touching");
        i.putExtras(bundle);
        startActivity(i);
    }
}

