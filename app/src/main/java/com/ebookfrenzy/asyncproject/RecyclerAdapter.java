package com.ebookfrenzy.asyncproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<String> names;

    public RecyclerAdapter(ArrayList<String> names) {
        this.names = names;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int i) {
        viewHolder.textView.setText(names.get(i));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name);
        }
    }

    public void clearList() {
        int size = names.size();
        names.clear();
        notifyItemRangeRemoved(0, size);
    }

}
