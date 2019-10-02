package com.example.batmobilapp.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.batmobilapp.R;
import com.example.batmobilapp.data.remote.FirebaseService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
        signUp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserInfoAndRegister();
            }
        });
    }
    private void getUserInfoAndRegister(){
        name = etName.getText().toString().trim();
        surname = etSurname.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        confirmPassword = etConfirmPassword.getText().toString().trim();
        if(!name.isEmpty() && !surname.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()){
            if(password.equals(confirmPassword)){
                register();
            }
        } else{
            Toast.makeText(this,"Edittextleri kontrol edin",Toast.LENGTH_LONG);
        }
    }

    private void register() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
}
