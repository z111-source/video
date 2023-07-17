package com.example.videodemo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.adapter.MyPagerAdapter;
import com.example.videodemo.adapter.MyRecycleAdapter;
import com.example.videodemo.fragment.PagerBottomFragment;
import com.example.videodemo.fragment.SecFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
//    private List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ViewPager2 viewPager = findViewById(R.id.view_paper);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, fragmentList);
        TabLayout tabLayout = findViewById(R.id.tab_down_layout);
        fragmentList = List.of(new PagerBottomFragment(), new SecFragment(),
                new PagerBottomFragment(), new PagerBottomFragment());
//        titles = List.of(getString(R.string.tab1), getString(R.string.tab2), getString(R.string.tab3), getString(R.string.tab4));
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(4);     //设置viewPager2最大页数
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {   //登记注册viewPaper2滑动监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });

        //TabLayoutMediator绑定tabLayout和viewPager2,注意.attach();
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {

        });
    }


}
