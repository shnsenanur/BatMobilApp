package com.example.batmobilapp.ui.fragment;

import android.app.ProgressDialog;
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
import com.example.batmobilapp.data.model.Data;
import com.example.batmobilapp.ui.adapter.CategoryAdapter;
import com.example.batmobilapp.utils.CategoryOnItemClickListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryListFragment extends Fragment implements CategoryOnItemClickListener {

    RecyclerView rvCategory;
    List<Category> categoryList;
    CategoryAdapter categoryAdapter;
    FirebaseAuth auth;
    DatabaseReference rf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Anasayfa");
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Devam eden işleminiz bulunmaktadır. Lütfen bekleyiniz..");
        progressDialog.show();
        auth = FirebaseAuth.getInstance();
        rf = FirebaseDatabase.getInstance().getReference().child("category");
        rvCategory = view.findViewById(R.id.rvCategory);
        categoryList = new ArrayList<>();

        rf.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    Data data = ds.getValue(Data.class);
                    Category cat = new Category(data.getId(),data.getCat(),data.getNumber()+" İçerik Var");
                    System.out.println(cat.getTitle());
                    categoryList.add(cat);
                }
                categoryAdapter = new CategoryAdapter(categoryList,CategoryListFragment.this);
                rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
                rvCategory.setAdapter(categoryAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        progressDialog.dismiss();
    }

    @Override
    public void OnItemClick(String title) {
        getFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, new QuestionListFragment().newInstance(title))
                .addToBackStack("QuestionListFragment").commit();
    }
}
