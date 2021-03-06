package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.utils.CategoryOnItemClickListener;

import java.util.List;


public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Category> itemsData;
    CategoryOnItemClickListener adapterOnItemClickListener;

    public CategoryAdapter(List<Category> itemsData, CategoryOnItemClickListener adapterOnItemClickListener) {
        this.itemsData = itemsData;
        this.adapterOnItemClickListener = adapterOnItemClickListener;
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCategoryIcon;
        TextView tvTitle;
        TextView tvSubtitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            ivCategoryIcon = itemLayoutView.findViewById(R.id.ivUserPhoto);
            tvTitle = itemLayoutView.findViewById(R.id.tvUsername);
            tvSubtitle = itemLayoutView.findViewById(R.id.tvRate);
        }

        public void bind(final Category item) {
            tvTitle.setText(item.getTitle());
            ivCategoryIcon.setImageResource(R.drawable.ic_dashboard_black_24dp);
            tvSubtitle.setText(item.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterOnItemClickListener.OnItemClick(item.getTitle());

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
