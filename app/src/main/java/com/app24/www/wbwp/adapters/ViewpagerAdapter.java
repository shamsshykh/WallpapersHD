package com.app24.www.wbwp.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app24.www.wbwp.fragment.CategoryFragment;
import com.app24.www.wbwp.fragment.PopularFragment;
import com.app24.www.wbwp.fragment.RecentFragment;

import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i == 0){
            return  new CategoryFragment();
        }if (i == 1){
            return  new RecentFragment();
        }if (i == 2){
            return  new PopularFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Categorys";
                case 1:
                    return "Recent";
                case 2:
                    return "Popular";
                    default:
                        return null;
            }
    }
}
