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
import com.example.videodemo.Book;
import com.example.videodemo.R;

import com.example.videodemo.adapter.MyRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecFragment extends Fragment {
    private final List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_top_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.sec_pager);
        initBookData();
        initRecyclerView();

    }
    private void initBookData() {
        Book book1 = new Book(getString(R.string.book_name), getString(R.string.book_state), R.id.img_recycle);
        for (int i = 0; i < 9; i++) {
            bookList.add(book1);
        }
    }
    private  void initRecyclerView(){
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(bookList);
        recyclerView.setAdapter(myRecycleAdapter);
    }
}
