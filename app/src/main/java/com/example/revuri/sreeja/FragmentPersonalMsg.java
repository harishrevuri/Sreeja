package com.example.revuri.sreeja;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentPersonalMsg extends android.support.v4.app.Fragment {

    private TextView title,title2,title3, content, content1, content2;
    private PersonalMsgAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_message, container, false);

        title = (TextView)view.findViewById(R.id.title_text);
        title2 = (TextView)view.findViewById(R.id.title_text_1);
        title3 = (TextView)view.findViewById(R.id.title_text_2);

        content =(TextView)view.findViewById(R.id.publish_date);
        content1 =(TextView)view.findViewById(R.id.publish_date_);
        content2 =(TextView)view.findViewById(R.id.publish_date_2);

        Typeface customTypeOne = Typeface.createFromAsset(view.getContext().getAssets(), "font/apple_chancery.ttf");
        title.setTypeface(customTypeOne);
        title2.setTypeface(customTypeOne);
        title3.setTypeface(customTypeOne);
        content.setTypeface(customTypeOne);
        content1.setTypeface(customTypeOne);
        content2.setTypeface(customTypeOne);
        myAdapter = new PersonalMsgAdapter(new ArrayList<PersonalMsgModel>());




        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
