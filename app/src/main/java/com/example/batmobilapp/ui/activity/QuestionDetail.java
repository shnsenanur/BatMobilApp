package com.example.batmobilapp.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.data.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionDetail extends AppCompatActivity {

    TextView tvTitle, tvDescription, tvUsername, tvDate, tvAnswer;
    RecyclerView rvComment;
    FirebaseAuth auth;
    DatabaseReference rf;
    FirebaseUser user;
    String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question_detail);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescription = findViewById(R.id.tvDescription);
        tvUsername = findViewById(R.id.tvUsername);
        tvDate = findViewById(R.id.tvDate);
        tvAnswer = findViewById(R.id.tvAnswer);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        id = getIntent().getExtras().getString("id");
        System.out.println(id);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        rf = FirebaseDatabase.getInstance().getReference().child("questions");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Question value = new Question();
                for (DataSnapshot ds:dataSnapshot.getChildren()) {
                    Question ques = ds.getValue(Question.class);
                    System.out.println(ques.getId());
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


        DatabaseReference rf2 = FirebaseDatabase.getInstance().getReference().child("users");
        rf2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User my = null;
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    User user = ds.getValue(User.class);
                    if (user.getId().equals(user.getId())){
                        my = user;
                    }

                }
                tvUsername.setText(my.getUsername());
                tvDate.setText("Puan: "+my.getUserRating());
                tvAnswer.setText(my.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
