package com.example.batmobilapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.ui.activity.QuestionDetail;
import com.example.batmobilapp.ui.fragment.QuestionDetailFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionListAdapter extends BaseAdapter {
    List<Question> liste = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    public QuestionListAdapter(Context context, List<Question> liste) {
        this.context = context;
        this.liste = liste;
    }

    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(context);
        final View v =  inflater.inflate(R.layout.item_question,null);
        TextView title = v.findViewById(R.id.tvUsername);
        TextView desc = v.findViewById(R.id.tvRate);
        title.setText(liste.get(position).getTitle());
        desc.setText(liste.get(position).getDescreption());
        QuestionDetailFragment qdf = new QuestionDetailFragment();
        Bundle args = new Bundle();
        args.putString("user_id",String.valueOf(liste.get(position).getId()));
        qdf.setArguments(args);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QuestionDetail.class);
                intent.putExtra("id",String.valueOf(liste.get(position).getId()));
                System.out.println(liste.get(position).getId());
                context.startActivity(intent);
            }
        });
        return v;
    }




}
