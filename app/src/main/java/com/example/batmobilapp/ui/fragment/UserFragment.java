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
        args.putParcelable("user", user);
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }
    public void collapseTable(View view) {
        TableLayout table = table.findViewById(table_flg);
        Button switchBtn = switchBtn.findViewById(switchBtn);

        // setColumnCollapsed(int columnIndex, boolean isCollapsed)
        table.setColumnCollapsed(1, table_flg);
        table.setColumnCollapsed(2, table_flg);

        if (table_flg) {
            // Close
            table_flg = false;
            switchBtn.setText("Show Detail");
        } else {
            // Open
            table_flg = true;
            switchBtn.setText("Hide Detail");
        }

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
