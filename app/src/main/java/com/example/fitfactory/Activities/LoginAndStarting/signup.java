package com.example.fitfactory.Activities.LoginAndStarting;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.Activities.medicaldetails;
import com.example.fitfactory.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class signup extends AppCompatActivity {
    public FirebaseFirestore fStore;
    Button signupbutton2;
    EditText registered_email, registered_password, registered_Username;
    FirebaseAuth fAuth;
    String userid;
    TextView loginhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupbutton2 = findViewById(R.id.signupbutton2);
        loginhere = findViewById(R.id.openloginactivity);
        registered_email = findViewById(R.id.RegisterEmail);
        registered_password = findViewById(R.id.RegisterPassword);
        registered_Username = findViewById(R.id.RegisterUsername);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        signupbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = registered_email.getText().toString().trim();
                String password = registered_password.getText().toString().trim();
                String username = registered_Username.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    registered_email.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    registered_password.setError("Password is required");
                    return;
                }
                if (password.length() < 6) {
                    registered_password.setError("Password should be greater than 6");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signup.this, "Account created", Toast.LENGTH_SHORT).show();
                            userid = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(email);
                            Map<String, Object> user = new HashMap<>();
                            user.put("email", email);
                            user.put("username", username);
                            user.put("medicaldetails", medicaldetails.getdiseasename());
                            user.put("gender",genderselection.getgender());
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d("TAG", "onSuccess: User id is created for " + userid);
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), genderselection.class));
                            finish();
                        } else {
                            Toast.makeText(signup.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                startActivity(intent);
            }
        });

    }


}