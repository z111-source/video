package com.example.videodemo.Utility;

import com.example.videodemo.book.Videos;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BookGson {

    public static List<Videos> handleVideoJson(String result) {
        Gson gson = new Gson();
        List<Videos> videosList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("videos");
            for (int i =0;i<7;i++){
                String data = jsonArray.getJSONObject(i).toString();
                Videos videos = gson.fromJson(data, Videos.class);
                videosList.add(videos);
            }
            //只有一个videos
            return videosList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
