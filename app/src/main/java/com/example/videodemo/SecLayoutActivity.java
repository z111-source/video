package com.example.videodemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.adapter.MyPagerAdapter;
import com.example.videodemo.fragment.PagerBottomFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class SecLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.frag_top_tab);
//        TabLayout tabLayout2 = findViewById(R.id.tab_top_layout);
//
//        ViewPager2 viewPager2 = findViewById(R.id.sec_pager);
//        viewPager2.setOffscreenPageLimit(7);
//
//        List<Fragment> fragmentList = List.of(new PagerBottomFragment(),new PagerBottomFragment(),new PagerBottomFragment(),
//                new PagerBottomFragment(),new PagerBottomFragment(),new PagerBottomFragment(),new PagerBottomFragment());
//        MyPagerAdapter myPagerAdapter2 = new MyPagerAdapter(this,fragmentList);
//        viewPager2.setAdapter(myPagerAdapter2);
//        viewPager2.setCurrentItem(0);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//        });
//
//        new TabLayoutMediator(tabLayout2, viewPager2, (tab, position) -> {
//
//        }).attach();


    }

}
