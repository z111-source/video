package com.example.videodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videodemo.BookActivity;
import com.example.videodemo.Http.HttpUtil;
import com.example.videodemo.book.Book;
import com.example.videodemo.R;
import com.example.videodemo.ChooseActivity;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private final List<Book> bookList;
    private final Context context;

    public MyRecycleAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false));     //root?
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Handler handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(Message msg) {
                Bitmap bitmap = (Bitmap) msg.obj;
                holder.imageView.setImageBitmap(bitmap);
            }
        };
        HttpUtil.sendHttpRequest(bookList.get(position).imageId, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("httpFail", "onFailure: 服务器获取失败");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                InputStream in = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                Message message = new Message();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        });
        holder.name.setText(bookList.get(position).name);
        int total = bookList.get(position).total;
        int state = bookList.get(position).state;
        String str ="";
        if (state==0){
            str = "(更新中)";
        }else if (state==1){
            str = "(已完结)";
        }
        String state1 = "共" + total + "集 "+str;
        holder.state.setText(state1);
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra("content",  bookList.get(position).content);
        intent.putExtra("title",bookList.get(position).name);
        holder.itemView.setOnClickListener(view -> {
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if (bookList == null) return 0;
        return bookList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView state;
        private final QMUIRadiusImageView2 imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_book_name);
            state = itemView.findViewById(R.id.tv_book_state);
            imageView = itemView.findViewById(R.id.img_recycle);
            imageView.setRadiusAndShadow(QMUIDisplayHelper.dp2px(imageView.getContext(), 10),
                    IQMUILayout.HIDE_RADIUS_SIDE_BOTTOM,
                    QMUIDisplayHelper.dp2px(imageView.getContext(), 20), 0.35f);
            //elevation扩散面积，Alpha颜色深浅

        }
    }
}
