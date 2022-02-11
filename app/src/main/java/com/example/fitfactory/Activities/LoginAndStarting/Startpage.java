package com.example.fitfactory.Activities.LoginAndStarting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.Activities.LoginAndStarting.signup;
import com.example.fitfactory.Activities.MainActivity.MainActivity;
import com.example.fitfactory.R;
import com.google.firebase.auth.FirebaseAuth;

public class Startpage extends AppCompatActivity {

    Button login, signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        login = findViewById(R.id.loginbutton1);
        signup = findViewById(R.id.signupbutton1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.fitfactory.Activities.LoginAndStarting.signup.class);
                startActivity(intent);
                finish();
            }
        });
        Button loginbutton, signupbutton;
        loginbutton = findViewById(R.id.loginbutton1);
        signupbutton = findViewById(R.id.signupbutton1);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupActivity();
            }
        });
    }

    public void openLoginActivity() {
        Intent intent = new Intent(this, loginactivity.class);
        startActivity(intent);
    }

    public void openSignupActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);

    }
}