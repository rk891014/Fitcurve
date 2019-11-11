package com.example.girls_fitness;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi_index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_index);
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

    public void calci(View view)
        {
            double height=0;
            double weight=0;
            double bmi=0;
            String msg="";

            EditText et1 = (EditText) findViewById(R.id.editText1);
            EditText et2 = (EditText) findViewById(R.id.editText2);
            Button b1 = (Button) findViewById(R.id.button2);
            TextView t1 = (TextView) findViewById(R.id.newtext2);
            TextView t2 = (TextView) findViewById(R.id.newtext3);
            weight= Double.parseDouble(et1.getText().toString());
            height= Double.parseDouble(et2.getText().toString());
            bmi=height*height;
            bmi=bmi/10000;
            bmi=weight/bmi;
            t1.setText(String.valueOf(bmi));
            if(bmi<18.5)
            {
                      msg=  "You are UNDERWEIGHT need to exercise";
            }
            else if(bmi>18.5&&bmi<25)
            {
                msg="Congrates you are FIT";

            }
            else if(bmi>25)
            {
                     msg=   "You are OVERWEIGHT need to exercise";
            }
            t2.setText(msg);
        }
}








