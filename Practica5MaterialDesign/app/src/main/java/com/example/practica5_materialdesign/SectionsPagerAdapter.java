package com.example.practica5_materialdesign;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Fragment1 fragment1;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                }
                return fragment1;
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Número de tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Home";
            case 1: return "Dashboard";
            case 2: return "Notifications";
            default: return null;
        }
    }

    public Fragment1 getFragment1() {
        return fragment1;
    }
}
