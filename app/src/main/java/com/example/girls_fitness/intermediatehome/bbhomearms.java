package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.arms2;

public class bbhomearms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomearms);
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
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Forearms Rotation");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Full Resistance Stretch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Plank To Downward Dog");
        i.putExtras(bundle);
        startActivity(i);
    }

    public void onclick3(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Pull And Down");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Punching");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Shoulder Touch Plank");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Side Plank");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Slice Cut");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Upper Hammering");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, arms2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdg","Weighted Arm Circles");
        i.putExtras(bundle);
        startActivity(i);
    }

}
