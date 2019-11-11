package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.sidefat3;

public class cchomesidefat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomesidefat);
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
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Cross knee Plank");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Glutes Touch Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Hip Lift Pulses");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Knee Swing");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Pilates Side Hip Raises");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Pull And Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Push And Knee Kick");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Rainbow Swoops");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Reverse Table Top");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, sidefat3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdac","Side Crunches");
        i.putExtras(bundle);
        startActivity(i);
    }

}

