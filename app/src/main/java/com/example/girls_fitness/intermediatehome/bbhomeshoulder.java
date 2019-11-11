package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.shoulder2;

public class bbhomeshoulder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomeshoulder);
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
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Back And Forth Hand");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this,shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Back Extension");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Bent Overrow");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Duck Swim");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Gripped Bent Overrows");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Half Rainbow arch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Knee To Chin Lift");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Scorpian Move");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Standing Wingfly");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, shoulder2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdd","Weighted Arm Circles");
        i.putExtras(bundle);
        startActivity(i);
    }


}
