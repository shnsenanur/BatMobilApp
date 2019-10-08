package com.example.batmobilapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QuestionDetailFragment extends Fragment {
    TextView tvTitle, tvDescription, tvUsername, tvDate, tvAnswer;
    RecyclerView rvComment;
    FirebaseAuth auth;
    DatabaseReference rf;
    FirebaseUser user;
    String id;

    public static QuestionDetailFragment newInstance(Question question) {
        Bundle args = new Bundle();
        //args.putParcelable("question", Question);
        QuestionDetailFragment fragment = new QuestionDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvDescription = view.findViewById(R.id.tvDescription);
        tvUsername = view.findViewById(R.id.tvUsername);
        tvDate = view.findViewById(R.id.tvDate);
        tvAnswer = view.findViewById(R.id.tvAnswer);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        id = getArguments().getString("user_id");
        rf = FirebaseDatabase.getInstance().getReference().child("questions");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Question value = new Question();
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                        Question ques = ds.getValue(Question.class);
                        if(ques.getId() == Integer.valueOf(id)) {
                            value = ques;
                        }
                }
                tvTitle.setText(value.getTitle());
                tvDescription.setText(value.getDescreption());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
            //tvTitle.setText(question.getTitle());
           // tvDescription.setText(question.getDescreption());
            //tvUsername.setText(question.getAnswerUsername());
           // tvDate.setText(question.getAnswerDate());
           // tvAnswer.setText(question.getAnswer());
            getActivity().setTitle("");
        }
    }

