package com.example.girls_fitness.BottomNavigationBarFragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.girls_fitness.PhotoAdapter;
import com.example.girls_fitness.R;
import com.example.girls_fitness.fragments.PhotoFragment;
import com.example.girls_fitness.fragments.Videofragment;
import com.google.android.material.tabs.TabLayout;

public class funfitness_fragment extends Fragment {


    View myFragment;

    public ViewPager viewPager;
    public TabLayout tabLayout;



    public static funfitness_fragment getInstance()    {
        return new funfitness_fragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment=inflater.inflate(R.layout.fragment_funfitness_fragment, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);

        return myFragment;
    }

    //Call onActivity Create method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        PhotoAdapter adapter = new PhotoAdapter(getChildFragmentManager());

        adapter.addFragment(new PhotoFragment(),"Photos");
        adapter.addFragment(new Videofragment(),"Video");

        viewPager.setAdapter(adapter);
    }
}