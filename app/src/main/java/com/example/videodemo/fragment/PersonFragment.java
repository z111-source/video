package com.example.videodemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.videodemo.R;
import com.example.videodemo.book.Person;

public class PersonFragment extends Fragment {
    private final Person person;

    public PersonFragment(Person person) {
        this.person = person;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = view.findViewById(R.id.img_head);
        TextView name = view.findViewById(R.id.tv_person_name);
        TextView phone = view.findViewById(R.id.tv_person_phone);
        imageView.setImageResource(person.getImageId());
        name.setText(person.getName());
        phone.setText(person.getPhone());
    }
}
