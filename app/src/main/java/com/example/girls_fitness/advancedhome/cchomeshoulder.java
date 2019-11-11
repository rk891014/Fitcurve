package com.example.girls_fitness.advancedhome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.AdvancedExercises.shoulder3;

public class cchomeshoulder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cchomeshoulder);
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
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Backarch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this,shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Back Hand Stretch");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Extension With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick3(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Hanging Weighted Rows");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Lie Down Rows");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Pike Shoulder Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Resistance Back Grip");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Resistance Band Rows");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Shoulder extension");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Shoulder Pull With Resistance Band");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick10(View view)
    {
        Intent i = new Intent(this, shoulder3.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIde","Shoulder pushups");
        i.putExtras(bundle);
        startActivity(i);
    }

}
