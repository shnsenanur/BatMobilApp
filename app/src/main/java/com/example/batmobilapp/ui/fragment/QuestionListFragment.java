package com.example.batmobilapp.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.ui.adapter.QuestionAdapter;
import com.example.batmobilapp.ui.adapter.QuestionListAdapter;
import com.example.batmobilapp.utils.QuestionOnItemClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionListFragment extends Fragment implements QuestionOnItemClickListener {

    ListView rvQuestion;
    List<Question> questionList;
    QuestionAdapter questionAdapter;
    DatabaseReference rf;
    FirebaseAuth auth;
    QuestionListAdapter cs;
    public static QuestionListFragment newInstance(String categoryName) {
        Bundle args = new Bundle();
        args.putString("categoryName", categoryName);
        QuestionListFragment fragment = new QuestionListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null) {
            getActivity().setTitle(extras.getString("categoryName")+" Soruları");

        }
        setHasOptionsMenu(true);
        rvQuestion = view.findViewById(R.id.rvQuestion);
        questionList = new ArrayList<>();
        Resources res = getResources();
        auth = FirebaseAuth.getInstance();
        rf = FirebaseDatabase.getInstance().getReference().child("questions");
        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    Question qs = ds.getValue(Question.class);
                    questionList.add(qs);
                }
                cs = new QuestionListAdapter(getContext(),questionList);
                rvQuestion.setAdapter(cs);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }

    @Override
    public void OnItemClick(Question question) {
        new QuestionDetailFragment();
        getFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,
                QuestionDetailFragment.newInstance(question))
        .addToBackStack("QuestionDetailFragment").commit();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_question_menu, menu);
    }
    private void loadFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFrameLayout, fragment)
                .addToBackStack(fragment.getTag())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
       switch (item.getItemId()) {
            case R.id.add:  selectedFragment = new AddFragment();
            break;
            default:
                break;
        }
        loadFragment(selectedFragment);
        return true;
    }
}
