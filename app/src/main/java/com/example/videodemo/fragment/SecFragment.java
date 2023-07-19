package com.example.videodemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.book.Book;
import com.example.videodemo.R;

import com.example.videodemo.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class SecFragment extends Fragment {
    private final List<Book> bookList;

    public SecFragment(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_top_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout2 = view.findViewById(R.id.tab_top_layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.sec_pager);

        List<String> titles = List.of(getString(R.string.tab5), getString(R.string.tab6), getString(R.string.tab7), getString(R.string.tab8), getString(R.string.tab9), getString(R.string.tab10), getString(R.string.tab11));
        List<Fragment> fragmentList = List.of(new PagerBottomFragment(bookList), new PagerBottomFragment(bookList), new PagerBottomFragment(bookList),
                new PagerBottomFragment(bookList), new PagerBottomFragment(bookList), new PagerBottomFragment(bookList), new PagerBottomFragment(bookList));
        MyPagerAdapter myPagerAdapter2 = new MyPagerAdapter(getActivity(), fragmentList);
        viewPager2.setAdapter(myPagerAdapter2);
        viewPager2.setCurrentItem(0);
        viewPager2.setOffscreenPageLimit(7);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        new TabLayoutMediator(tabLayout2, viewPager2, (tab, position) -> {
            tab.setText(titles.get(position));
        }).attach();
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//        });

    }

}
