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
import com.example.batmobilapp.ui.fragment.UserListFragment;

import java.util.List;


public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<User> itemsData;
    FragmentTransaction fragmentTransaction;

    public UserAdapter(List<User> itemsData, FragmentTransaction fragmentTransaction) {
        this.itemsData = itemsData;
        this.fragmentTransaction = fragmentTransaction;
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
        User apo = new User("1","danmarkq",21,"dfsdf");
        return apo;
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

        public void bind(User item) {
            System.out.println(item.getUsername());
            tvUsername.setText(item.getUsername());
            String rate= String.valueOf(item.getRate())+" Soru cevapladı.";
            tvRate.setText(rate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentTransaction.replace(R.id.mainFrameLayout, new UserListFragment());
                    fragmentTransaction.addToBackStack("UserListFragment");
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

