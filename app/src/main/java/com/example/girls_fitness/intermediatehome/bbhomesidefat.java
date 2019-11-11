package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.sidefat2;

public class bbhomesidefat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomesidefat);
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
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Arm Raises Plank");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Arms Over Knee");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Can Can Abs");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Cross Body Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Cross Punch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Head Drop");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Heel Touch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Knee To Elbow Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Reclined Oblique Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, sidefat2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdab","Standing Ab Bike");
        i.putExtras(bundle);
        startActivity(i);
    }

}