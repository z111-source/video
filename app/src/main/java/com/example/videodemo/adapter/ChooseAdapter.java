package com.example.videodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videodemo.BookActivity;
import com.example.videodemo.ChooseActivity;
import com.example.videodemo.book.Choose;
import com.example.videodemo.R;

import java.util.List;

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.ViewHolder> {
    private final List<Choose> chooses;
    private final Context context;

    public ChooseAdapter(List<Choose> chooses, Context context) {
        this.chooses = chooses;
        this.context = context;
    }

    @NonNull
    @Override
    public ChooseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseAdapter.ViewHolder holder, int position) {
        holder.bookNum.setText(chooses.get(position).getBookNum());
        holder.bookIntro.setText(chooses.get(position).getBookIntro());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (chooses == null) return 0;
        return chooses.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView bookNum;
        private final TextView bookIntro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookNum = itemView.findViewById(R.id.book_num);
            bookIntro = itemView.findViewById(R.id.book_num_intro);
        }
    }
}
