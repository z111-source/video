package com.example.videodemo.book;

import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("videoSource")
    public String videoSource;

    @SerializedName("title")
    public String name;

    @SerializedName("state")
    public String state;

    @SerializedName("coverImage")
    public int imageId;

    @SerializedName("desc")
    public String content;

    @SerializedName("type")
    public String type;

}
