package com.example.girls_fitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.girls_fitness.BottomNavigationBarFragment.HomeFragment;
import com.example.girls_fitness.BottomNavigationBarFragment.funfitness_fragment;
import com.example.girls_fitness.generalexercises.GeneralExercises;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_Workout_Training extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //    FragmentManager fragmentManager;
//    FragmentTransaction fragmentTransaction;
//    BottomNavigationView navView2;
//
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            switch (menuItem.getItemId()) {
//                case R.id.navigation_home:
//
//                    menuItem.expandActionView();
//                    fragmentManager = getSupportFragmentManager();
//                    fragmentTransaction = fragmentManager.beginTransaction();
//                    HomeFragment homeFragment = new HomeFragment();
//                    fragmentTransaction.replace(R.id.fragment_container, homeFragment, null).commit();
//                    return true;
//
//                case R.id.photo_fragment:
//                    menuItem.expandActionView();
//                    fragmentManager = getSupportFragmentManager();
//                    fragmentTransaction = fragmentManager.beginTransaction();
//                    PhotoFragment photoFragment=new PhotoFragment();
//                    fragmentTransaction.replace(R.id.fragment_container, photoFragment, null).commit();
//                    return true;
//
//            }
//            return true;
//        }
//    };
//
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__workout__training);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTheme(R.style.AppTheme);

        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.photo_fragment:
                fragment = new funfitness_fragment();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


//
//        BottomNavigationView navView2 = findViewById(R.id.nav_view2);
//        navView2.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemIconTintList(null);
//
//
//        final ImageView imageView1 = findViewById(R.id.imageView1);
//
//        final Handler handler = new Handler();
//        Runnable runnable = new Runnable() {
//            int i = 0;
//            int[] imageArray = {R.drawable.motivation, R.drawable.crunches,
//                    R.drawable.abs, R.drawable.donkeykick};
//
//            public void run() {
//                imageView1.setImageResource(imageArray[i]);
//                Animation animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_left);
//                imageView1.startAnimation(animSlideDown);
//                i++;
//                if (i > imageArray.length - 1) {
//                    i = 0;
//                }
//                handler.postDelayed(this, 5000);
//            }
//        };
//        handler.postDelayed(runnable, 5000);
//
//
//
//
//    }
//
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home__workout__training, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
    public void onclick(View view) {
        Intent i = new Intent(this, homebeginner.class);
        startActivity(i);
    }

    public void onclick1(View view) {
        Intent i = new Intent(this, homeintermediate.class);
        startActivity(i);
    }

    public void onclick2(View view) {
        Intent i = new Intent(this, homeadvanced.class);
        startActivity(i);
    }

    public void onclick3(View view) {
        Intent i = new Intent(this, warmup.class);
        startActivity(i);
    }
    public void onclick4(View view) {
        Intent i = new Intent(this, cooldown.class);
        startActivity(i);
    }
    public void onclick5(View view) {
        Intent i = new Intent(this, GeneralExercises.class);
        startActivity(i);
    }

//
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_home) {
//            Intent i = new Intent(this, NewsActivity.class);
//            startActivity(i);
//        } else if (id == R.id.nav_gallery) {
//            Intent i = new Intent(this, uploadvideo.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_comment_us) {
//            Intent i = new Intent(this, comment_us.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_bmi) {
//
//            Intent i = new Intent(this, Motivational_Quotes.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_share) {
//            Intent shareintent = new Intent();
//            shareintent.setAction(Intent.ACTION_SEND);
//            shareintent.putExtra(Intent.EXTRA_TEXT, "hmara app");
//            shareintent.setType("text/plain");
//            startActivity(Intent.createChooser(shareintent, "share via"));
//
//        } else if (id == R.id.nav_rate_us) {
//            try {
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("market://details?id=" + getPackageName())));
//            } catch (ActivityNotFoundException e) {
//                startActivity(new Intent(Intent.ACTION_VIEW,
//                        Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
//            }
//            AppRate.with(this)
//                    .setInstallDays(1)
//                    .setLaunchTimes(3)
//                    .setRemindInterval(2)
//                    .monitor();
//            AppRate.showRateDialogIfMeetsConditions(this);
//
//
//        }
//
//        DrawerLayout drawer = findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//
//    }
//}
}