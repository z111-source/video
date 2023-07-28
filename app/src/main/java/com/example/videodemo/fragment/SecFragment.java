package com.example.videodemo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;

import android.os.Bundle;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.R;

import com.example.videodemo.TabLayoutActivity;
import com.example.videodemo.adapter.MyPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;

public class SecFragment extends Fragment {
    List<Fragment> fragmentList;
    private MyListener myListener;
    private Boolean isScroll = false;

    public SecFragment(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    public interface MyListener {
        public void sendValues1(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) { //activity和fragment联系时候调用，fragment必须依赖activity
        super.onAttach(context);
        myListener = (MyListener) getActivity();
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
        ImageButton search = view.findViewById(R.id.btn_search);

        List<String> titles = List.of(getString(R.string.tab5), getString(R.string.tab7), getString(R.string.tab8), getString(R.string.tab9), getString(R.string.tab10), getString(R.string.tab11), getString(R.string.tab12));

        MyPagerAdapter myPagerAdapter2 = new MyPagerAdapter(getActivity(), fragmentList);
//        viewPager2.setOnTouchListener(new View.OnTouchListener() {
//            float startX;
//            float endX;
//
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.d("isLeft", "sendValues1: " + isLeft);
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        startX = motionEvent.getX();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        endX = motionEvent.getX();
//                        if (endX - startX > 0) {
//                            isLeft = true;
//                        } else if (endX - startX < 0) {isRight = true;
//                        }
//                        break;
//                }
//                return false;
//            }
//        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                myListener.sendValues1(position);
                Log.d("position", "onPageScrolled: " + position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if (state == 1) {   //开始滑动
                    isScroll = false;
                }
                if (state == 2) {   //滑动结束
                    isScroll = true;
                }
                if (state == 0) {   //啥都没做
                    if (!isScroll) {   //没有滑动

                    }
                }
            }
        });
        viewPager2.setAdapter(myPagerAdapter2);
        viewPager2.setCurrentItem(0);
        viewPager2.setOffscreenPageLimit(7);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        new TabLayoutMediator(tabLayout2, viewPager2, (tab, position) -> {
            tab.setText(titles.get(position));

        }).attach();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
