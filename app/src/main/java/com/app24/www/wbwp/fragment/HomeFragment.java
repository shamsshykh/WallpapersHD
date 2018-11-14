package com.app24.www.wbwp.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app24.www.wbwp.R;
import com.app24.www.wbwp.adapters.ViewpagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewpagerAdapter viewpagerAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = view.findViewById(R.id.tabMode);
        viewPager = view.findViewById(R.id.viewPager);
        setViewPager();
        return view;
    }


    private void setViewPager(){
        viewpagerAdapter = new ViewpagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
