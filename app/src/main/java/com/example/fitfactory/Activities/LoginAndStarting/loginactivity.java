package com.example.fitfactory.Activities.LoginAndStarting;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.Activities.MainActivity.MainActivity;
import com.example.fitfactory.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class loginactivity extends AppCompatActivity {
    Button loginbutton2;
    TextView createnewaccount;
    ProgressBar progressBar;
    EditText loginemail;
    TextInputEditText loginpassword;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        loginbutton2 = findViewById(R.id.loginbutton2);
        createnewaccount = findViewById(R.id.createnewaccount);
        progressBar = findViewById(R.id.progressBar);
        loginpassword = findViewById(R.id.Login_Password);
        loginemail = findViewById(R.id.Login_Email);
        fAuth = FirebaseAuth.getInstance();

        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });
        loginbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginemail.getText().toString().trim();
                String password = Objects.requireNonNull(loginpassword.getText()).toString().trim();


                if (TextUtils.isEmpty(email)) {
                    loginemail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    loginpassword.setError("Password is required");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginactivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else {
                            Toast.makeText(loginactivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }

        });
    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
}