package com.example.videodemo.book;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videos{
    @SerializedName("name")
    public String videoName;

    public List<Book> bookList;

}
