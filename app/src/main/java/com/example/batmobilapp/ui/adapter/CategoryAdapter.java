package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.ui.fragment.QuestionListFragment;

import java.util.List;

    public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Category> itemsData;
    FragmentTransaction fragmentTransaction;

    public CategoryAdapter(List<Category> itemsData,FragmentTransaction fragmentTransaction) {
        this.itemsData = itemsData;
        this.fragmentTransaction=fragmentTransaction;
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
            ivCategoryIcon = itemLayoutView.findViewById(R.id.ivCategoryIcon);
            tvTitle = itemLayoutView.findViewById(R.id.tvTitle);
            tvSubtitle = itemLayoutView.findViewById(R.id.tvSubtitle);
        }

        public void bind(Category item) {
            tvTitle.setText(item.getTitle());
            tvSubtitle.setText(item.getDescription());
            ivCategoryIcon.setImageDrawable(item.getIcon());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentTransaction.replace(R.id.mainFrameLayout, new QuestionListFragment());
                    fragmentTransaction.addToBackStack("QuestionListFragment");
                    fragmentTransaction.commit();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
