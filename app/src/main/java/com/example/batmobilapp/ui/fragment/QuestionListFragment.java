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
import com.example.batmobilapp.utils.QuestionOnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class QuestionListFragment extends Fragment implements QuestionOnItemClickListener {

    RecyclerView rvQuestion;
    List<Question> questionList;
    QuestionAdapter questionAdapter;
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
        rvQuestion = view.findViewById(R.id.rvQuestion);
        questionList = new ArrayList<>();
        Resources res = getResources();
        questionList.add(new Question(1,"Soru Başlığı","Soru Açıklaması ",
                "cevaplayan kişinin adı","Cevaplanma Tarihi","Cevap İçeriği"));
        questionAdapter = new QuestionAdapter(questionList,this);
        rvQuestion.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvQuestion.setAdapter(questionAdapter);
    }

    @Override
    public void OnItemClick(Question question) {
        new QuestionDetailFragment();
        getFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,
                QuestionDetailFragment.newInstance(question))
        .addToBackStack("QuestionDetailFragment").commit();
    }
}
