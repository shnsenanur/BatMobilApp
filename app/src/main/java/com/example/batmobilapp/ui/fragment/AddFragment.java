package com.example.batmobilapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFragment extends Fragment {

    EditText title, content;
    Button add;
    DatabaseReference rf;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.edt_bookName);
        content = view.findViewById(R.id.edt_yazar);
        add = view.findViewById(R.id.add);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rf = FirebaseDatabase.getInstance().getReference().child("questions").child(user.getUid());
                Question qs = new Question(1,title.getText().toString(),content.getText().toString(),1);
                rf.setValue(qs);
            }
        });

    }

}
