package com.example.fitfactory.Activities.AllPosture;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitfactory.R;

public class Yoga_postures extends AppCompatActivity {
    CardView allpostures, recommendedpostures;
    int color = Color.parseColor("#0E1C36");
    int color2 = Color.parseColor("#C5D5EA");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_postures);
        allpostures = findViewById(R.id.allpostures);
        recommendedpostures = findViewById(R.id.recommendedpostures);
        replaceFragment(new all_postures());
        allpostures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new all_postures());
                allpostures.setCardBackgroundColor(color);
                recommendedpostures.setCardBackgroundColor(color2);
            }
        });
        recommendedpostures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new recommendedpostures());
                recommendedpostures.setCardBackgroundColor(color);
                allpostures.setCardBackgroundColor(color2);
            }
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.yoganavigator, fragment);
        fragmentTransaction.commit();
    }

}