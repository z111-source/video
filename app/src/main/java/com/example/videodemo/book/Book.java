package com.example.videodemo.book;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Book implements Serializable {
    @SerializedName("videoSource")
    public String videoSource;

    @SerializedName("title")
    public String name;
    @SerializedName("total")
    public int total;

    @SerializedName("status")
    public int state;

    @SerializedName("coverImage")
    public String imageId;

    @SerializedName("desc")
    public String content;

    @SerializedName("type")
    public String type;

}
