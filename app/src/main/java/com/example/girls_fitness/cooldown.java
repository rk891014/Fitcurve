package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;

public class cooldown extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooldown);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Anklesway Left");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Armscissors");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Full Lie Burpee");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","High Stepping");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Hiproll");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Jogging");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Jumping Jack");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Jumping Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Laptap");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Skipping Without Rope");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Stairs Jumping");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Stairs Jumping With Both Leg");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick12(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Stepping High");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick13(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Unilateral Jump");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick14(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","ankleswayright");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick15(View view)
    {
        Intent i = new Intent(this, cooldown1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdad","Xmenjump");
        i.putExtras(bundle);
        startActivity(i);
    }
}

