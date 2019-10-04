package com.example.batmobilapp.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.User;

public class UserFragment extends Fragment {

TextView tvUsername;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUsername=view.findViewById(R.id.tvUsername);

        Bundle extras = getArguments();
        if (extras != null) {
            User user= (User) extras.getParcelable("user");
            tvUsername.setText(user.getUsername());
        }
    }
}
