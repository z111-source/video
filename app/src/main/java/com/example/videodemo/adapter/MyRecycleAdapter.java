package com.example.videodemo.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videodemo.Book;
import com.example.videodemo.R;

import java.util.List;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private final List<Book> bookList;

    public MyRecycleAdapter( List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false));     //root?
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        holder.imageView.setImageResource(bookList.get(position).getImageId());
        holder.name.setText(bookList.get(position).getName());
        holder.state.setText(bookList.get(position).getState());
    }

    @Override
    public int getItemCount() {
        if (bookList == null) return 0;
        return bookList.size();
    }

     static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView state;
        private final ImageView imageView;

        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_book_name);
            state = itemView.findViewById(R.id.tv_book_state);
            imageView = itemView.findViewById(R.id.img_recycle);
        }
    }
}
