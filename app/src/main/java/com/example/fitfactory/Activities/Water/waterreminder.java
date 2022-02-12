package com.example.fitfactory.Activities.Water;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.FitFactory.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.messaging.FirebaseMessaging;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class waterreminder extends AppCompatActivity {
    ProgressBar watertracker;
    TextView waterprogress;
    FloatingActionButton addtoprogress;
    CardView addwater, addcofee, addtea, addsoftdrink, addjuice;
    CircleImageView messagesettings;
    int currentday = 1;
    int selected;
    int color2 = Color.parseColor("#ABC9FB");
    int colorwhite = Color.parseColor("#FFFFFF");
    float progress = 0;
    int textprogress = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterreminder);
        selected = 10;
        watertracker = findViewById(R.id.waterlevel);
        watertracker.setMax(100);
        waterprogress = findViewById(R.id.waterprogress);
        addtoprogress = findViewById(R.id.addtotarget);
        addwater = findViewById(R.id.addwater);
        addcofee = findViewById(R.id.addcofee);
        addtea = findViewById(R.id.addtea);
        addsoftdrink = findViewById(R.id.addsoftdrink);
        addjuice = findViewById(R.id.addjuice);
        messagesettings = findViewById(R.id.messagesettings);
//        Date currentTime = Calendar.getInstance().getTime();
        loaddata();
        Date currentdateassign = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        Log.d("currentdate", "onCreate: " + formatter.format(currentdateassign));
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        Log.d("currentday", "currentday " + dayOfWeek + "  " + currentday);
//        if(currentTime.equals("00 00 00 00 00 00"));
        if (dayOfWeek != currentday) {
            System.out.println("i am in this block");
            currentday = dayOfWeek;
            progress = 0;
            textprogress = 0;
            savedata();
            loaddata();
            waterprogress.setText("" + 0 + " OF 2400");
            watertracker.setProgress(Math.round(0));
        }
        Log.d("currentday", "currentday " + dayOfWeek + "  " + currentday);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        addtoprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selected == 0) {
                    progress = progress + (200 * 100 / 2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress = textprogress + 200;
                    addwater.setCardBackgroundColor(colorwhite);
                    selected = 10;
                } else if (selected == 1) {
                    progress = progress + (100 * 100 / 2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress = textprogress + 100;
                    addcofee.setCardBackgroundColor(colorwhite);
                    selected = 10;
                } else if (selected == 2) {
                    progress = progress + (150 * 100 / 2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress = textprogress + 150;
                    addtea.setCardBackgroundColor(colorwhite);
                    selected = 10;
                } else if (selected == 3) {
                    progress = progress + (250 * 100 / 2400) + 1;
                    watertracker.setProgress(Math.round(progress));
                    textprogress = textprogress + 250;
                    addsoftdrink.setCardBackgroundColor(colorwhite);
                    selected = 10;
                } else if (selected == 4) {
                    progress = progress + (200 * 100 / 2400);
                    watertracker.setProgress(Math.round(progress));
                    textprogress = textprogress + 200;
                    addjuice.setCardBackgroundColor(colorwhite);
                    selected = 10;
                } else if (selected == 10) {
                    Toast.makeText(waterreminder.this, "Please select an item to add", Toast.LENGTH_SHORT).show();
                }
                waterprogress.setText("" + textprogress + " OF 2400");
                Log.d("waterprogress", "onClick: " + progress);
            }
        });
        addwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 0;
                addwater.setCardBackgroundColor(color2);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addcofee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 1;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(color2);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addtea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 2;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(color2);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        addsoftdrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 3;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(colorwhite);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(color2);
            }
        });
        addjuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected = 4;
                addwater.setCardBackgroundColor(colorwhite);
                addcofee.setCardBackgroundColor(colorwhite);
                addjuice.setCardBackgroundColor(color2);
                addtea.setCardBackgroundColor(colorwhite);
                addsoftdrink.setCardBackgroundColor(colorwhite);
            }
        });
        messagesettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), waternotificationsettings.class);
                startActivity(intent);
                finish();
            }
        });
    }

    void savedata() {

        SharedPreferences sharedpreference = getSharedPreferences("water", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreference.edit();
        editor.putInt("progress", textprogress);
        editor.putFloat("barprogress", progress);
        editor.putInt("daycheck", currentday);
        editor.apply();
    }

    void loaddata() {
        SharedPreferences getvalue = getSharedPreferences("water", MODE_PRIVATE);
        textprogress = getvalue.getInt("progress", MODE_PRIVATE);
        progress = getvalue.getFloat("barprogress", MODE_PRIVATE);
        currentday = getvalue.getInt("daycheck", MODE_PRIVATE);
        waterprogress.setText("" + textprogress + " OF 2400");
        watertracker.setProgress(Math.round(progress));
        Log.d("waterreminder", "onClick: " + textprogress + " " + progress);
    }

    @Override
    protected void onPause() {
        super.onPause();
        savedata();
    }
}