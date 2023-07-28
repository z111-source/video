package com.example.videodemo;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.videodemo.adapter.MyPagerAdapter;
import com.example.videodemo.book.Book;
import com.example.videodemo.book.Person;
import com.example.videodemo.book.Videos;
import com.example.videodemo.fragment.PagerBottomFragment;
import com.example.videodemo.fragment.PersonFragment;
import com.example.videodemo.fragment.SecFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements SecFragment.MyListener {
    private List<Book> bookList0;
    private List<Videos> videosList;
    private Person person;
    private List<Book> bookList1;
    private List<Book> bookList2;
    private List<Book> bookList3;
    private List<Book> bookList4;
    private List<Book> bookList5;
    private List<Book> bookList6;
    private List<Book> bookList7;
    private ViewPager2 viewPager;
    private Boolean isLeft = false;
    private Boolean isRight = false;
    private Boolean isScroll = false;
    private int position1;
    float startX = 0;
    float endX = 0;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                break;
            case MotionEvent.ACTION_UP:
                endX = ev.getX();
                if (endX - startX > 0) {
                    isLeft = true;
                } else if (endX - startX < 0) {
                    isRight = true;
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_page);
        viewPager = findViewById(R.id.view_paper);
        TabLayout tabLayout = findViewById(R.id.tab_down_layout);
        videosList = getJson();
        initBookData();
        initPersonData();

        List<Fragment> fragmentList2 = List.of(new PagerBottomFragment(bookList1), new PagerBottomFragment(bookList2), new PagerBottomFragment(bookList3),
                new PagerBottomFragment(bookList4), new PagerBottomFragment(bookList5), new PagerBottomFragment(bookList6), new PagerBottomFragment(bookList7));
        List<Fragment> fragmentList = List.of(new PagerBottomFragment(bookList0), new SecFragment(fragmentList2),
                new PagerBottomFragment(bookList6), new PersonFragment(person));

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(this, fragmentList);

        List<String> titles = List.of(getString(R.string.tab1), getString(R.string.tab2), getString(R.string.tab3), getString(R.string.tab4));

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {   //登记注册viewPaper2滑动监听
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                viewPager.setUserInputEnabled(position != 1);
                Log.d("isLeft", "onPageScrolled: " + isLeft);
//                if (position == 1) {
//                    if (position1 == 0 && isLeft) {
//                        viewPager.setCurrentItem(0);
//                        viewPager.setUserInputEnabled(true);
//                    } else if (position1 == 6 && isRight) {
//                        viewPager.setCurrentItem(2);
//                    }
//                }
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
                        if (position1 == 0 && isLeft) {
                            viewPager.setCurrentItem(0);
                        } else if (position1 == 6 && isRight) {
                            viewPager.setCurrentItem(2);
                        }
                    }
                }
            }
        });
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setCurrentItem(1);
        viewPager.setOffscreenPageLimit(4);     //设置viewPager2最大页数
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(titles.get(position));
        }).attach(); //TabLayoutMediator绑定tabLayout和viewPager2,注意.attach();
    }

    public List<Videos> getJson() {
        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("book.json")); //转换流，读取文件中的字节并将其转换为字符
            Gson gson = new Gson();
            Type listVd = new TypeToken<List<Videos>>() {
            }.getType();
            isr.close();                //记得关闭
            return gson.fromJson(isr, listVd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initBookData() {
        for (int i = 0; i < videosList.size(); i++) {
            String name = videosList.get(i).videoName;
            switch (name) {
                case "推荐":
                    bookList1 = videosList.get(i).bookList;
                    break;
                case "逆袭":
                    bookList2 = videosList.get(i).bookList;
                    break;
                case "爱情":
                    bookList3 = videosList.get(i).bookList;
                    break;
                case "重生":
                    bookList4 = videosList.get(i).bookList;
                    bookList0 = videosList.get(i).bookList;
                    break;
                case "赘婿":
                    bookList5 = videosList.get(i).bookList;
                    break;
                case "神医":
                    bookList6 = videosList.get(i).bookList;
                    break;
                case "家庭":
                    bookList7 = videosList.get(i).bookList;
                    break;
                default:
                    break;
            }
        }
    }

    private void initPersonData() {
        person = new Person("小周", "13533675914", R.drawable.head);
    }

    @Override
    public void sendValues1(int position) {
        position1 = position;
    }
}
