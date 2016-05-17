package com.orobator.recyclerviewbugdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AndrewOrobator on 5/17/16.
 */
public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.MyViewHolder>{
    ArrayList<Integer> items = new ArrayList<>();

    public DemoAdapter() {
        for (int i = 0; i < 100; i++) {
            items.add(i);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText("Item " + items.get(position));

        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.colorPrimary);
        } else {
            holder.itemView.setBackgroundResource(R.color.gray);
        }
    }

    public void move(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int oldPos = viewHolder.getAdapterPosition();
        int newPos = target.getAdapterPosition();

        int item = items.remove(oldPos);
        items.add(newPos, item);
        notifyItemMoved(oldPos, newPos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
