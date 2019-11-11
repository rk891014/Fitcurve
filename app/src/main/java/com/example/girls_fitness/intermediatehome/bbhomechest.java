package com.example.girls_fitness.intermediatehome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.girls_fitness.R;
import com.example.girls_fitness.IntermediateExercises.chest2;

public class bbhomechest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbhomechest);
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
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Chest Stretch On Toes");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick1(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","First Fly Accros Head");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick2(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Fist Flies");
        i.putExtras(bundle);
        startActivity(i);
    }

    public void onclick3(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Half Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick4(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Head Pullover");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick5(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Knee Pushups");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick6(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Pike Chest Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick7(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Shoulder Swing");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick8(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Single Hand Chest Press");
        i.putExtras(bundle);
        startActivity(i);
    }
    public void onclick9(View view)
    {
        Intent i = new Intent(this, chest2.class);
        Bundle bundle = new Bundle();
        bundle.putString("videoIdm","Standing Chest Press Move");
        i.putExtras(bundle);
        startActivity(i);
    }

}
