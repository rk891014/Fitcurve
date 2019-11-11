package com.example.girls_fitness.generalexercises;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.girls_fitness.R;
import com.google.android.material.tabs.TabLayout;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GeneralExercises extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewpager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_exercises);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTheme(R.style.AppTheme);
        mTabLayout=(TabLayout)findViewById(R.id.tabLayout);
        mViewpager=(ViewPager)findViewById(R.id.viewPager);
        setupViewPager(mViewpager);
        mTabLayout.setupWithViewPager(mViewpager);
        mViewpager.setCurrentItem(1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager){
        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new facetonningfragment(),"Face Tonning");
        adapter.addFragment(new backpainfragment(),"Back Pain Relief");
        adapter.addFragment(new periodsfragment(),"Periods Pain Relief");
        adapter.addFragment(new hairfallfragment(),"Hair Fall Control");
        adapter.addFragment(new eyestrainrelief(),"Eye Strain Relief");
        viewPager.setAdapter(adapter);
    }


    public class viewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titleList = new ArrayList<>();

        public viewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

        public void addFragment(Fragment fragment, String title)    {
            fragmentList.add(fragment);
            titleList.add(title);
        }
    }



}
