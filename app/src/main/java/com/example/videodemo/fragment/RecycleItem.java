package com.example.videodemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.videodemo.Book;
import com.example.videodemo.R;

public class RecycleItem extends Fragment {
    private Book book;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycle_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.img_recycle);
        TextView tv_name =  view.findViewById(R.id.tv_book_name);
        TextView tv_state = view.findViewById(R.id.tv_book_state);
        imageView.setImageResource(book.getImageId());
        tv_name.setText(book.getName());
        tv_state.setText(book.getState());

    }
}
