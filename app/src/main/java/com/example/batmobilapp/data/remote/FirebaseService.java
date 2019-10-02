package com.example.batmobilapp.data.remote;

import androidx.annotation.NonNull;

import com.example.batmobilapp.data.model.Category;
import com.example.batmobilapp.utils.IResponseListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirebaseService {

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    public final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    public void getCategoryList(final IResponseListener<List<Category>> responseListener) {
        final List<Category> categories = new ArrayList<>();
        db.collection("event").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for (DocumentSnapshot document : task.getResult()) {
                    categories.add(document.toObject(Category.class));
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                responseListener.OnError(e.getMessage());
            }
        });
    }
}
