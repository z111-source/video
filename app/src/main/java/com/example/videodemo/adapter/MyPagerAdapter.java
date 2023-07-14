package com.example.videodemo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> mFragmentList;

    public MyPagerAdapter(FragmentActivity fragmentActivity, List<Fragment> mFragmentList) {
        super(fragmentActivity);
        this.mFragmentList = mFragmentList;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        if (mFragmentList == null)
            return 0;
        return mFragmentList.size();
    }
}
