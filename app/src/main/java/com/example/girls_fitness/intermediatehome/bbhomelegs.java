package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.legs2;

public class bbhomelegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomelegs);
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
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Backward Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Forward Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Full Ballet Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Jumping squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Lunge Knee Hope");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Mountain Climber With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Reverse Back Stretch Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Sumo squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, legs2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdq","Two Strokes squats");
        i.putExtras(bundle);
        startActivity(i);
    }

}
