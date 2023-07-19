package com.example.videodemo.book;

import android.widget.ImageView;

public class Book {
    private String name;
    private String state;
    private int imageId;

    public Book(String name, String state, int imgId) {
        this.name = name;
        this.state = state;
        this.imageId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
