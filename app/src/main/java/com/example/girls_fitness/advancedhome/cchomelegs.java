package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.legs3;

public class cchomelegs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomelegs);
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
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Chest Expander On Squate Pose");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Curtsy Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Knee Jump");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Knee To Chest Jump");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Lunges With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Pop squats");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Resistance Backgrip");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","Side Lunges");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","squats On Toes");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, legs3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdr","squats With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }

}
