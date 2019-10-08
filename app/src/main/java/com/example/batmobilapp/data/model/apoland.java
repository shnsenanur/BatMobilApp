package com.example.batmobilapp.data.model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.batmobilapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class apoland extends AppCompatActivity {


    EditText catname, catid, number;
    Button ekle;
    FirebaseAuth auth;
    DatabaseReference rf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoland);
        catname = findViewById(R.id.catname);
        catid = findViewById(R.id.catid);
        number = findViewById(R.id.number);
        ekle = findViewById(R.id.ekle);
        auth = FirebaseAuth.getInstance();


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rf = FirebaseDatabase.getInstance().getReference("category").child(catname.getText().toString());
                Data apo = new Data(catname.getText().toString(),number.getText().toString(), Integer.valueOf(catid.getText().toString()));
                rf.setValue(apo);
                startActivity(new Intent(apoland.this,apoland.class));
            }
        });

    }
}
