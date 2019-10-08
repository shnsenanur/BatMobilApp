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
import com.example.batmobilapp.utils.UserOnItemClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserListFragment extends Fragment implements UserOnItemClickListener {
    RecyclerView rvUser;
    List<User> userList;
    UserAdapter userAdapter;
    EditText etUsername;
    FirebaseAuth auth;
    DatabaseReference rf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Kullanıcılar");
        rvUser = view.findViewById(R.id.rvUser);
        etUsername = view.findViewById(R.id.etUsername);
        userList = new ArrayList<>();
        auth = FirebaseAuth.getInstance();
        rf = FirebaseDatabase.getInstance().getReference().child("users");
        etUsername.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                List<User> filterList = new ArrayList<>();
                for (User user : userList) {
                    if (user.getUsername().contains(s.toString())) {
                        filterList.add(user);
                    }
                }
                userAdapter = new UserAdapter(filterList, UserListFragment.this);
                rvUser.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvUser.setAdapter(userAdapter);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    @Override
    public void OnItemClick(User user) {
        getFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new UserFragment().newInstance(user))
                .addToBackStack("QuestionListFragment")
                .commit();
    }
}



