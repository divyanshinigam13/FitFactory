package com.example.fitfactory.Activities.Bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitfactory.R;


import java.util.ArrayList;

public class DietPlanner extends AppCompatActivity {
    RecyclerView recyclerType;
    ArrayList<Category> arrayList = new ArrayList<>();
    CategoryAdapter adapter;
    Button knowBmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_planner);
        recyclerType = findViewById(R.id.recyclerType);
        knowBmi = findViewById(R.id.knowBmi);
        knowBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietPlanner.this, BmiCalculator.class);
                startActivity(intent);
            }
        });
        arrayList.add(new Category("Under Weight", "<18.5", R.mipmap.ic_launcher));
        arrayList.add(new Category("Healthy", "18.5-24.9", R.mipmap.ic_launcher));
        arrayList.add(new Category("Over Weight", ">24.9", R.mipmap.ic_launcher));
        recyclerType.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryAdapter(arrayList, this);
        recyclerType.setAdapter(adapter);

    }
}