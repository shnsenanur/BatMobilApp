package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Category> itemsData;

    public CategoryAdapter(List<Category> itemsData) {
        this.itemsData = itemsData;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(getItem(position));
    }


    private Category getItem(int position) {
        if (itemsData != null) {
            return itemsData.get(position);
        }
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivCategoryIcon;
        TextView tvTitle;
        TextView tvSubtitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            ivCategoryIcon=itemLayoutView.findViewById(R.id.ivCategoryIcon);
            tvTitle=itemLayoutView.findViewById(R.id.tvTitle);
            tvSubtitle=itemLayoutView.findViewById(R.id.tvSubtitle);
            itemView.setOnClickListener(this);
        }

        public void bind(Category item) {
            tvTitle.setText(item.getTitle());
            tvSubtitle.setText(item.getDescription());
            ivCategoryIcon.setImageDrawable(item.getIcon());
        }

        @Override
        public void onClick(View view) {

        }
    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
