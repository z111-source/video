package com.example.videodemo;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.videodemo.adapter.ChooseAdapter;
import com.example.videodemo.book.Choose;

import java.util.List;

public class ChooseActivity extends AppCompatActivity {

    private List<Choose> chooses;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_tab_common);
        initChoose();
        RecyclerView recyclerView = findViewById(R.id.recycle);
        ChooseAdapter chooseAdapter = new ChooseAdapter(chooses, this);
        recyclerView.setAdapter(chooseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));


    }
    private void initChoose(){
        chooses = List.of(new Choose(getString(R.string.num_1),getString(R.string.intro_1)),
                new Choose(getString(R.string.num_2),getString(R.string.intro_1)),
                new Choose(getString(R.string.num_3),getString(R.string.intro_2)),
                new Choose(getString(R.string.num_4),getString(R.string.intro_3)),
                new Choose(getString(R.string.num_5),getString(R.string.intro_4)),
                new Choose(getString(R.string.num_6),getString(R.string.intro_5)),
                new Choose(getString(R.string.num_7),getString(R.string.intro_6)),
                new Choose(getString(R.string.num_8),getString(R.string.intro_4)),
                new Choose(getString(R.string.num_9),getString(R.string.intro_6)),
                new Choose(getString(R.string.num_10),getString(R.string.intro_5)),
                new Choose(getString(R.string.num_11),getString(R.string.intro_2)),
                new Choose(getString(R.string.num_12),getString(R.string.intro_3)));
    }
}
