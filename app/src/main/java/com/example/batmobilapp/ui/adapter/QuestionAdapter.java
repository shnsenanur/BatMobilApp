package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.utils.QuestionOnItemClickListener;

import java.util.List;


public class QuestionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Question> itemsData;
    QuestionOnItemClickListener questionOnItemClickListener;

    public QuestionAdapter(List<Question> itemsData, QuestionOnItemClickListener questionOnItemClickListener) {
        this.itemsData = itemsData;
        this.questionOnItemClickListener = questionOnItemClickListener;
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
            tvSubtitle.setText(item.getDescreption());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    questionOnItemClickListener.OnItemClick(item);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}
