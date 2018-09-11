package com.example.revuri.sreeja;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentPics extends android.support.v4.app.Fragment {

    private static final String TAG = FragmentPics.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    //private MyAdapter myAdapter;
    private LicenseListAdapter myAdapter;
    private DatabaseReference mDatabaseRef;
    private DatabaseReference childRef;

    public FragmentPics() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pics, container, false);

        linearLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.mRecylcerID);
        //recyclerView.setHasFixedSize(true);
        myAdapter = new LicenseListAdapter(new ArrayList<FirebaseModel>());



        childRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                FirebaseModel bean = (FirebaseModel) dataSnapshot.getValue(FirebaseModel.class);
                if(bean != null) {
                    System.out.println("-- image retrieved ["+bean.getUrl()+"] -- ");
                    myAdapter.addItems(Arrays.asList(bean));
                } else {
                    System.out.println("-- image retrieved [NULL] -- ");
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                myAdapter.clearItems();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);


        recyclerView.setAdapter(myAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference();
        childRef = mDatabaseRef.child("images");
    }
}
