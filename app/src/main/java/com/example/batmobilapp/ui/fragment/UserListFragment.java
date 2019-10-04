package com.example.batmobilapp.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.User;
import com.example.batmobilapp.ui.adapter.UserAdapter;
import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment {
    RecyclerView rvUser;
    List<User> userList;
    UserAdapter userAdapter;
    EditText etUsername;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.rvUser);
        etUsername = view.findViewById(R.id.etUsername);
        userList = new ArrayList<>();
        userList.add(new User("1","sena",21,""));
        userList.add(new User("1","sumeyye",21,""));
        userList.add(new User("1","burcu",21,""));
        userList.add(new User("1","ayşe",21,""));
        userAdapter = new UserAdapter(userList,getFragmentManager().beginTransaction());
        rvUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvUser.setAdapter(userAdapter);
        etUsername.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                List<User> filterList=new ArrayList<>();
                for(User user : userList){
                    if(user.getUsername().contains(s.toString())){
                        filterList.add(user);
                    }
                }
                userAdapter = new UserAdapter(filterList,getFragmentManager().beginTransaction());
                rvUser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvUser.setAdapter(userAdapter);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }
}



