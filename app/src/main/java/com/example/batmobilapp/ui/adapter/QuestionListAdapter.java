package com.example.batmobilapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.ui.fragment.QuestionDetailFragment;

import java.util.ArrayList;
import java.util.List;

public class QuestionListAdapter extends BaseAdapter {
    List<Question> liste = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    Activity activity;
    public QuestionListAdapter(Context context, List<Question> liste, Activity activity) {
        this.context = context;
        this.liste = liste;
        this.activity = activity;
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
    public View getView(int position, View convertView, ViewGroup parent) {
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
                Fragment fragment = null;
                activity.getgetSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainFrameLayout, fragment)
                        .addToBackStack(fragment.getTag())
                        .commit();
            }
        });
        return v;
    }


}
