package com.example.videodemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videodemo.book.Book;
import com.example.videodemo.R;
import com.example.videodemo.adapter.MyRecycleAdapter;

import java.util.List;

public class PagerBottomFragment extends Fragment {
    private final List<Book> mBookList;
    private RecyclerView recyclerView;

    public PagerBottomFragment(List<Book> bookList) {
        this.mBookList = bookList;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tab_common, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        initRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initRecyclerView() {
//        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
//        pagerSnapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(mBookList, getContext());
        recyclerView.setAdapter(myRecycleAdapter);
    }
}
