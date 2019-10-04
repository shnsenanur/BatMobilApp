package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.ui.fragment.QuestionDetailFragment;
import com.example.batmobilapp.ui.fragment.QuestionListFragment;

import java.util.List;


    public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Question> itemsData;
    FragmentTransaction fragmentTransaction;

    public QuestionAdapter(List<Question> itemsData,FragmentTransaction fragmentTransaction) {
        this.itemsData = itemsData;
        this.fragmentTransaction=fragmentTransaction;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(getItem(position));
    }


    private Question getItem(int position) {
        if (itemsData != null) {
            return itemsData.get(position);
        }
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvSubtitle;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvTitle = itemLayoutView.findViewById(R.id.tvUsername);
            tvSubtitle = itemLayoutView.findViewById(R.id.tvRate);
        }

        public void bind(final Question item) {
            tvTitle.setText(item.getTitle());
            tvSubtitle.setText(item.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentTransaction.replace(R.id.mainFrameLayout,
                            new QuestionDetailFragment().newInstance(item.getTitle(),item.getId()));
                    fragmentTransaction.addToBackStack("QuestionDetailFragment");
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
