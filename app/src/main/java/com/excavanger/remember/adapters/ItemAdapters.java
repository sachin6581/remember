package com.excavanger.remember.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.excavanger.remember.R;
import com.excavanger.remember.models.ItemModel;

import java.util.List;

public class ItemAdapters extends RecyclerView.Adapter<ItemAdapters.ItemHolder> {

    private List<ItemModel> itemModelList;

    public ItemAdapters(List<ItemModel> itemModelList) {
        this.itemModelList = itemModelList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            holder.itemTitle.setBackgroundColor(Color.parseColor(itemModelList.get(position).getBackgroundColor()));
            holder.itemTitle.setText(itemModelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{
        private final CardView cardView;
        private final TextView itemTitle;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_bg_card);
            itemTitle = itemView.findViewById(R.id.item_title);
        }
    }
}
