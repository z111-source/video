package com.example.videodemo.book;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Videos {

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @SerializedName("name")
    public String videoName;
    @SerializedName("videoList")
    public List<Book> bookList;


}
