package com.example.batmobilapp.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.User;

public class UserFragment extends Fragment {


    TextView tvUsername, tvAge;
    RatingBar ratingBar;
    Button switchBtn;

    private boolean table_flg = false;

    public static UserFragment newInstance(User user) {
        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvAge = view.findViewById(R.id.tvAge);
        ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

            }
        });

        Bundle extras = getArguments();
        if (extras != null) {
            User user = (User) extras.getParcelable("user");
            getActivity().setTitle(user.getUsername());
            tvUsername.setText(user.getUsername());
            tvAge.setText(String.valueOf(user.getAge())+" Yaşında");
        }
    }
}
