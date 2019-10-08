package com.example.batmobilapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.batmobilapp.R;
import com.example.batmobilapp.data.model.User;
import com.example.batmobilapp.data.remote.FirebaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    FirebaseService service;
    Button signUp_btn;
    EditText etName,etEmail,etPassword,etSurname,etConfirmPassword;
    String name;
    String surname;
    String email;
    String password;
    String confirmPassword;
    FirebaseAuth mAuth;
    Spinner age;
    ArrayAdapter<String> ages;
    String [] agesV;
    String ageValue;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        signUp_btn = findViewById(R.id.signUp_btn);
        etName=findViewById(R.id.etName);
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        etSurname=findViewById(R.id.etSurname);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
        age=findViewById(R.id.age);
        setAgeSpinner();
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserInfoAndRegister();
            }
        });
    }

    private void setAgeSpinner() {
        agesV = new String[100];
        for (int i=0; i<100; i++){
            agesV[i] = ""+i;
        }
        ages = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,agesV);
        ages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        age.setAdapter(ages);
    }

    private void getUserInfoAndRegister(){
        name = etName.getText().toString().trim();
        surname = etSurname.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();
        ageValue = age.getSelectedItem().toString().trim();
        if(!name.isEmpty() && !surname.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if(password.equals(confirmPassword)){
                register();
            }
        } else{
            Toast.makeText(this,"Edittextleri kontrol edin",Toast.LENGTH_LONG);
        }
    }

    private void register() {
        if (Integer.valueOf(ageValue) > 18) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            DatabaseReference users = FirebaseDatabase.getInstance().getReference("users");
                                            auth = FirebaseAuth.getInstance();
                                            String id = auth.getCurrentUser().getUid();
                                            User us = new User(id,name+" "+surname,Integer.valueOf(ageValue),email,0,"default");
                                            users.child(id).setValue(us);
                                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                            finish();
                                        }
                                        else{
                                            Toast.makeText(RegisterActivity.this,"Bir Hata Oluştu. Lütfen Tekrar Deneyiniz.", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

        }

        else {
            Toast.makeText(getApplicationContext(),"18 Yaşından Küçükler Kayıt Olamaz", Toast.LENGTH_LONG).show();
        }
    }
}
