package com.example.batmobilapp.ui.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.data.model.Question;
import com.example.batmobilapp.ui.adapter.CategoryAdapter;
import com.example.batmobilapp.ui.adapter.QuestionAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionListFragment extends Fragment {

    RecyclerView rvQuestion;
    List<Question> questionList;
    QuestionAdapter questionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvQuestion = view.findViewById(R.id.rvQuestion);
        questionList = new ArrayList<>();
        Resources res = getResources();
        questionList.add(new Question(1,"a","b"));
        questionAdapter = new QuestionAdapter(questionList,getFragmentManager().beginTransaction());
        rvQuestion.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvQuestion.setAdapter(questionAdapter);
    }

}
