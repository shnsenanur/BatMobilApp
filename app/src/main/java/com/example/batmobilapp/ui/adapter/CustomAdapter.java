package com.example.batmobilapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.batmobilapp.data.model.Problems;
import com.example.batmobilapp.R;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    List<Problems> liste = new ArrayList<>();
    LayoutInflater inflater;
    Context context;
    public CustomAdapter(Context context, List<Problems> liste) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(context);
        View screen =  inflater.inflate(R.layout.problems_design,null);
        //final TextView problemsTxt = screen.findViewById(R.id.yoklama_isim);
        //final ImageView problemsIcn = screen.findViewById(R.id.aaa);
        //final TextView problemsSayAbout = screen.findViewById(R.id.ddddd);
        final Problems uye = liste.get(position);



        return screen;
    }
    public void temizle()
    {
        liste.clear();
    }
}