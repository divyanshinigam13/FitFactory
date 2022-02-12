package com.example.fitfactory.Activities;



import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.R;

public class oxygencalculator extends AppCompatActivity {
    TextView oxygenlevel;
    int o2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygencalculator);
        oxygenlevel = findViewById(R.id.oxygenlevel);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            o2 = bundle.getInt("o2r");
            oxygenlevel.setText(String.valueOf(o2));
        }
    }
}