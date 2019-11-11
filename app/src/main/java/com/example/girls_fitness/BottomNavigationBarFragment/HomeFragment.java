package com.example.girls_fitness.BottomNavigationBarFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.girls_fitness.R;
import com.example.girls_fitness.homeadvanced;
import com.example.girls_fitness.homebeginner;
import com.example.girls_fitness.homeintermediate;
import com.example.girls_fitness.warmup;
import com.google.android.material.navigation.NavigationView;


public class HomeFragment extends Fragment {

    Context mcontext;
    ImageView imageView1;
    private static final String TAG = "Home_Workout_Training";



    public HomeFragment(){

    }

    @Override
    public void onAttach(Context context) {
        this.mcontext=context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        //imageView1= v.findViewById(R.id.imageView1);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






//
//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i = 0;
//            int[] imageArray = {R.drawable.motivation, R.drawable.crunches,
//                    R.drawable.abs, R.drawable.donkeykick};
//
//            public void run() {
//                imageView1.setImageResource(imageArray[i]);
//                Animation animSlideDown = AnimationUtils.loadAnimation(mcontext, R.anim.slide_in_left);
//                imageView1.startAnimation(animSlideDown);
//                i++;
//                if (i > imageArray.length - 1) {
//                    i = 0;
//                }
//                handler.postDelayed(this, 5000);
//            }
//        };
//        handler.postDelayed(runnable, 5000);


//        public void onclick(View view) {
//            Intent i = new Intent(mcontext, homebeginner.class);
//            startActivity(i);
//        }
//
//
//        public void onclick1(View view) {
//            Intent i = new Intent(mcontext, homeintermediate.class);
//            startActivity(i);
//        }
//
//        public void onclick2(View view) {
//            Intent i = new Intent(mcontext, homeadvanced.class);
//            startActivity(i);
//        }
//
//        public void onclick3(View view) {
//            Intent i = new Intent(mcontext, warmup.class);
//            startActivity(i);
//        }


    }
}
