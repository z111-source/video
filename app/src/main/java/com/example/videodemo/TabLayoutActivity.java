package com.example.videodemo;

import android.annotation.SuppressLint;
import android.os.Bundle;

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
    private List<String> titles = new ArrayList<>();
    private List<Book> bookList;
    private RecyclerView recyclerView;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        List<RecyclerView> recyclerViewList = new ArrayList<RecyclerView>();
        recyclerViewList.add(recyclerView);
        ViewPager2 viewPager = findViewById(R.id.view_paper);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, fragmentList);
        TabLayout tabLayout = findViewById(R.id.tab_down_layout);
        tabLayout.addTab(new TabLayout.Tab(), 0, false);
        tabLayout.addTab(new TabLayout.Tab(), 1, true);
        tabLayout.addTab(new TabLayout.Tab(), 2, false);
        tabLayout.addTab(new TabLayout.Tab(), 3, false);
        fragmentList = List.of(new PagerBottomFragment(recyclerViewList.get(0)), new SecFragment(),
                new PagerBottomFragment(recyclerViewList.get(1)), new PagerBottomFragment(recyclerViewList.get(2)));
        titles = List.of(getString(R.string.tab1), getString(R.string.tab2), getString(R.string.tab3), getString(R.string.tab4));
        bookList = new ArrayList<>();
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(bookList);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setAdapter(myRecycleAdapter);
        initBookData();
        myRecycleAdapter.notifyDataSetChanged();    //recycleAdapter数据更新
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setOffscreenPageLimit(4);     //设置viewPager2最大页数
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {   //登记注册viewPaper2滑动监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });

        //TabLayoutMediator绑定tabLayout和viewPager2,注意.attach();
        new TabLayoutMediator(tabLayout, viewPager, true, (tab, position) -> tab.setText(titles.get(position))).attach();
    }

    private void initBookData() {
        Book book1 = new Book(getString(R.string.book_name), getString(R.string.book_state), R.id.img_recycle);
        for (int i = 0; i < 9; i++) {
            bookList.add(book1);
        }
    }
}
