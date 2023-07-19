package com.example.videodemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.videodemo.book.Detail;

import java.util.List;

public class BookActivity extends AppCompatActivity {
    private Detail detail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_1);
        initDetails();
        TextView bookTitle = findViewById(R.id.tv_book_title);
        TextView bookContent = findViewById(R.id.text_book_content);
        bookTitle.setText(detail.getBookTitle());
        bookContent.setText(detail.getBookContent());
    }
    private void initDetails(){
        detail =new Detail("第一","哈哈哈哈");
    }
}
