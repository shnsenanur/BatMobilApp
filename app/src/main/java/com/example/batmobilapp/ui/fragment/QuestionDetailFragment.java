package com.example.batmobilapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.batmobilapp.R;

public class QuestionDetailFragment extends Fragment {

    public static QuestionDetailFragment newInstance(String question,int questionId) {
        Bundle args = new Bundle();
        args.putString("question", question);
        args.putInt("questionId", questionId);
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
        Bundle extras = getArguments();
        if (extras != null) {
            getActivity().setTitle(extras.getString("question"));
        }
    }
}
