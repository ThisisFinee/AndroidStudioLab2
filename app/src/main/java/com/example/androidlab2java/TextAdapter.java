package com.example.androidlab2java;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<String> purchases;
    TextAdapter(Context context, List<String> purchases){
        this.purchases = purchases;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TextAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.purchases_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextAdapter.ViewHolder holder, int position){
        String purchase = purchases.get(position);
        holder.textView.setText(purchase);
    }

    @Override
    public int getItemCount() {
        return purchases.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setItems(String purchase) {
        purchases.add(purchase);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearItems() {
        purchases.clear();
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void deleteItem(String purchase){
        purchases.remove(purchase);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.purchase);
        }
    }

}
