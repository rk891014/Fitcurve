package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class warmup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warmup);
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
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Anklesway Left");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Armscissors");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Full Lie Burpee");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","High Stepping");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Hiproll");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Jogging");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Jumping Jack");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Jumping Twist");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Laptap");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Skipping Without Rope");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Stairs Jumping");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick11(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Stairs Jumping With Both Leg");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick12(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Stepping High");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick13(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Unilateral Jump");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick14(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","ankleswayright");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick15(View view)
    {
        Intent i = new Intent(this, warmup1.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdo","Xmenjump");
        i.putExtras(bundle);
        startActivity(i);
    }
}
