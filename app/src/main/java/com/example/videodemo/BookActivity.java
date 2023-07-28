package com.example.videodemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.videodemo.book.Book;
import com.example.videodemo.book.Videos;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_1);
        TextView bookTitle = findViewById(R.id.tv_book_title);
        TextView bookContent = findViewById(R.id.text_book_content);
        Book book = new Book();
        book.content= getIntent().getStringExtra("content");
        book.name=getIntent().getStringExtra("title");
        String name =book.name;
        String content =book.content;
        bookTitle.setText(name);
        bookContent.setText(content);

    }

}
