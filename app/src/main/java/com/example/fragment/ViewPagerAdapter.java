package com.example.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm) { // to manage the fragment add or replace the fragments...
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { // replace or add at particular position...
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new StatusFragment();
        } else {
            return new CallFragment();
        }
    }

    @Override
    public int getCount() { // size of your fragments...
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) { // fragment name in the tab layout...
        if (position == 0) {
            return "Home";
        } else if (position == 1) {
            return "Status";
        } else {
            return "Call";
        }
    }
}
