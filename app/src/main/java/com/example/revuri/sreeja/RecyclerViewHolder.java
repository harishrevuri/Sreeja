package com.example.revuri.sreeja;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    View mView;
    Context mContext;
    ImageView imageView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        imageView = (ImageView)itemView.findViewById(R.id.image);
    }
}
