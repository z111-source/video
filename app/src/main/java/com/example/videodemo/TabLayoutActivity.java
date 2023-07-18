package com.example.videodemo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.adapter.MyPagerAdapter;
import com.example.videodemo.fragment.PagerBottomFragment;
import com.example.videodemo.fragment.SecFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private List<Book> bookList1;
    private List<Book> bookList3;
    private List<Book> bookList4;
    private List<Book> bookList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        ViewPager2 viewPager = findViewById(R.id.view_paper);
        initBookData();

        List<Fragment> fragmentList = List.of(new PagerBottomFragment(bookList1), new SecFragment(bookList),
                new PagerBottomFragment(bookList3), new PagerBottomFragment(bookList4));

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, fragmentList);
        TabLayout tabLayout = findViewById(R.id.tab_down_layout);

        List<String> titles = List.of(getString(R.string.tab1), getString(R.string.tab2), getString(R.string.tab3), getString(R.string.tab4));
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(4);     //设置viewPager2最大页数
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(titles.get(position));
        }).attach();
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {   //登记注册viewPaper2滑动监听
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//        });

        //TabLayoutMediator绑定tabLayout和viewPager2,注意.attach();
    }

    private void initBookData() {
        bookList1 = List.of(new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name5), getString(R.string.book_state5), R.drawable.img_5),
                new Book(getString(R.string.book_name4), getString(R.string.book_state4), R.drawable.img_4),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1),
                new Book(getString(R.string.book_name2), getString(R.string.book_state5), R.drawable.img_2),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1));
        bookList3 = List.of(new Book(getString(R.string.book_name5), getString(R.string.book_state5), R.drawable.img_5),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name4), getString(R.string.book_state4), R.drawable.img_4),
                new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name2), getString(R.string.book_state5), R.drawable.img_2),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1));
        bookList4 = List.of(new Book(getString(R.string.book_name4), getString(R.string.book_state4), R.drawable.img_4),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name2), getString(R.string.book_state2), R.drawable.img_2),
                new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name2), getString(R.string.book_state5), R.drawable.img_2),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1));
        bookList = List.of(new Book(getString(R.string.book_name4), getString(R.string.book_state4), R.drawable.img_4),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name2), getString(R.string.book_state2), R.drawable.img_2),
                new Book(getString(R.string.book_name6), getString(R.string.book_state2), R.drawable.img_6),
                new Book(getString(R.string.book_name2), getString(R.string.book_state5), R.drawable.img_2),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1),
                new Book(getString(R.string.book_name3), getString(R.string.book_state3), R.drawable.img_3),
                new Book(getString(R.string.book_name1), getString(R.string.book_state1), R.drawable.img_1));
    }
}
