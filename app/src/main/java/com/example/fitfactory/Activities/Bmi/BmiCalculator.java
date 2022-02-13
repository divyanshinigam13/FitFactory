package com.example.fitfactory.Activities.Bmi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.R;


public class BmiCalculator extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText weight, feet, inches, centi;
    Button cal, diet;
    int wgt, ft, in, cm;
    double bm;
    TextView bmi;
    String body;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        weight = findViewById(R.id.weight);
        feet = findViewById(R.id.feet);
        inches = findViewById(R.id.inches);
        centi = findViewById(R.id.centi);
        bmi = findViewById(R.id.bmi);
        spin = findViewById(R.id.spin);
        centi.setVisibility(View.INVISIBLE);


        cal = findViewById(R.id.cal);
        diet = findViewById(R.id.diet);
        diet.setVisibility(View.INVISIBLE);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (feet.length() != 0 && inches.length() != 0 && weight.length() != 0) {
                    wgt = Integer.parseInt(weight.getText().toString());
                    ft = Integer.parseInt(feet.getText().toString());
                    in = Integer.parseInt(inches.getText().toString());
                    bm = wgt / Math.pow((ft * 0.3048) + (in * 0.0254), 2);
                } else if (centi.length() != 0 && weight.length() != 0) {
                    wgt = Integer.parseInt(weight.getText().toString());
                    cm = Integer.parseInt(centi.getText().toString());
                    bm = (wgt * 10000) / (Math.pow(cm, 2));
                } else {
                    Toast.makeText(BmiCalculator.this, "Enter the values", Toast.LENGTH_SHORT).show();
                }
                String fin = String.format("%.1f", bm);
                if (bm <= 18.5) {
                    body = "Under Weight";
                    bmi.setTextColor(Color.parseColor("#ffff00"));
                } else if (bm > 18.5 && bm <= 24.9) {
                    body = "Healthy";
                    bmi.setTextColor(Color.parseColor("#26c821"));
                } else if (bm > 24.9 && bm <= 29.9) {
                    body = "Over Weight";
                    bmi.setTextColor(Color.parseColor("#f16032"));
                } else {
                    body = "Obese";
                    bmi.setTextColor(Color.parseColor("#ff0000"));
                }
                if (bm != 0) {
                    diet.setVisibility(View.VISIBLE);
                    bmi.setText(fin + " " + body);
                }

            }
        });
        diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BmiCalculator.this, DietChart.class);
                intent.putExtra("TypeCheck", true);
                intent.putExtra("TypeSent", body);
                startActivity(intent);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            feet.setVisibility(View.VISIBLE);
            inches.setVisibility(View.VISIBLE);
            centi.setVisibility(View.INVISIBLE);
            feet.setText("");
            inches.setText("");
            centi.setText("");
        }
        if (position == 1) {
            feet.setVisibility(View.INVISIBLE);
            inches.setVisibility(View.INVISIBLE);
            centi.setVisibility(View.VISIBLE);
            feet.setText("");
            inches.setText("");
            centi.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public static class Menu {
        String time, menu;

        public Menu(String time, String menu) {
            this.time = time;
            this.menu = menu;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMenu() {
            return menu;
        }

        public void setMenu(String menu) {
            this.menu = menu;
        }
    }
}