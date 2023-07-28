package com.example.videodemo.Http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;



public class HttpUtil {
    public static void sendHttpRequest(String address,okhttp3.Callback callback){
        Request request = new Request.Builder().url(address).get().build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
