package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.chest3;

public class cchomechest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomechest);
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
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Back Hammering");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Bench Pushups With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Chest Expand");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Chest Expander On Squatpose");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Divebomber Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Hiplift Chest Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Pushups And Knee Kick With Chair");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Single Leg Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, chest3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdn","Upper Chest Press");
        i.putExtras(bundle);
        startActivity(i);
    }
}
