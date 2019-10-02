package com.example.batmobilapp.ui.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.data.model.User;
import com.example.batmobilapp.ui.adapter.CategoryAdapter;
import com.example.batmobilapp.ui.adapter.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment {
    RecyclerView rvUser;
    List<User> userList;
    UserAdapter userAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.rvUser);
        userList = new ArrayList<>();
        userList.add(new User("1","sena",21,""));
        userAdapter = new UserAdapter(userList,getFragmentManager().beginTransaction());
        rvUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUser.setAdapter(userAdapter);
    }
}



