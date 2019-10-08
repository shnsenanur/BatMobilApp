package com.example.batmobilapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.User;
import com.example.batmobilapp.ui.fragment.QuestionListFragment;
import com.example.batmobilapp.ui.fragment.UserFragment;
import com.example.batmobilapp.ui.fragment.UserListFragment;
import com.example.batmobilapp.utils.UserOnItemClickListener;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> itemsData;
    UserOnItemClickListener userOnItemClickListener;

    public UserAdapter(List<User> itemsData, UserOnItemClickListener userOnItemClickListener) {
        this.itemsData = itemsData;
        this.userOnItemClickListener = userOnItemClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bind(getItem(position));
    }


    private User getItem(int position) {
        if (itemsData != null) {
            return itemsData.get(position);
        }

        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivUserPhoto;
        TextView tvUsername;
        TextView tvRate;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            ivUserPhoto = itemLayoutView.findViewById(R.id.image_view);
            tvUsername = itemLayoutView.findViewById(R.id.text_view1);
            tvRate = itemLayoutView.findViewById(R.id.text_view2);
        }

        public void bind(final User item) {
            System.out.println(item.getUsername());
            tvUsername.setText(item.getUsername());
            //String rate= String.valueOf(item.getRate())+" Soru cevapladı.";
            //tvRate.setText(rate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userOnItemClickListener.OnItemClick(item);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return itemsData.size();
    }

}

