package com.example.videodemo.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videodemo.book.Book;
import com.example.videodemo.R;
import com.example.videodemo.ChooseActivity;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private final List<Book> bookList;
    private final Context context;

    public MyRecycleAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false));     //root?
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.imageView.setImageResource(bookList.get(position).imageId);
        holder.name.setText(bookList.get(position).name);
        holder.state.setText(bookList.get(position).state);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ChooseActivity.class);
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

        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_book_name);
            state = itemView.findViewById(R.id.tv_book_state);
            imageView = itemView.findViewById(R.id.img_recycle);
            imageView.setRadiusAndShadow( QMUIDisplayHelper.dp2px(imageView.getContext(), 10),
                    IQMUILayout.HIDE_RADIUS_SIDE_BOTTOM,
                    QMUIDisplayHelper.dp2px(imageView.getContext(), 20), 0.35f);
                    //elevation扩散面积，Alpha颜色深浅

        }
    }
}
