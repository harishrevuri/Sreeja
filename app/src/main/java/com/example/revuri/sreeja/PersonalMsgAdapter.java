package com.example.revuri.sreeja;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PersonalMsgAdapter extends RecyclerView.Adapter<PersonalMsgAdapter.ViewHolder>{

    private final List<PersonalMsgModel> msgModels;

    public PersonalMsgAdapter(List<PersonalMsgModel> msgModels) {
        this.msgModels = msgModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_msg_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(msgModels.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void addItems(List<PersonalMsgModel> licenses) {
        msgModels.addAll(licenses);
        this.notifyDataSetChanged();
    }

    public void clearItems() {
        msgModels.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textView, textView1;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            textView = itemView.findViewById(R.id.title_text);
            textView1 = itemView.findViewById(R.id.content_text);
        }

        public void bind(PersonalMsgModel personalMsgModel) {
            textView.setText(personalMsgModel.getHeading());
            textView1.setText(personalMsgModel.getValue());
        }
    }
}
