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

public class QuestionDetailFragment extends Fragment {
    TextView tvTitle, tvDescription, tvUsername, tvDate, tvAnswer;
    RecyclerView rvComment;

    public static QuestionDetailFragment newInstance(Question question) {
        Bundle args = new Bundle();
        args.putParcelable("question", question);
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
        Bundle extras = getArguments();
        if (extras != null) {
            Question question = extras.getParcelable("question");
            tvTitle.setText(question.getTitle());
            tvDescription.setText(question.getDescription());
            tvUsername.setText(question.getAnswerUsername());
            tvDate.setText(question.getAnswerDate());
            tvAnswer.setText(question.getAnswer());
            getActivity().setTitle("");
        }
    }
}
