package com.example.revuri.sreeja;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class LicenseListAdapter extends RecyclerView.Adapter<LicenseListAdapter.ViewHolder> {

    private final List<FirebaseModel> mValues;

    public LicenseListAdapter(List<FirebaseModel> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(mValues.get(position));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void addItems(List<FirebaseModel> licenses) {
        mValues.addAll(licenses);
        this.notifyDataSetChanged();
    }

    public void clearItems() {
        mValues.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView imageView;
        public final TextView textView;

        Typeface customTypeOne = Typeface.createFromAsset(itemView.getContext().getAssets(), "font/apple_chancery.ttf");

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageView = view.findViewById(R.id.image);
            textView = view.findViewById(R.id.text);

        }

        public void bind(FirebaseModel license) {
            Glide.with(mView.getContext()).load(license.getUrl()).asBitmap().into(imageView);
            textView.setText(license.getText());
            textView.setTypeface(customTypeOne);
        }
    }
}