package com.example.girls_fitness.beginnerhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.BeginnerExercises.shoulder1;

public class aahomeshoulder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aahomeshoulder);
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
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Back Pulling");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this,shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Bird Fly");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Circle Pulls");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Cris Cros Hands");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Floating Hands");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Full Hand Rotation");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Lying Wing Fly");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Prayer Pulses");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Shoulder Move");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, shoulder1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdc","Standing Scorpian Move");
        i.putExtras(bundle);
        startActivity(i);
    }


}
