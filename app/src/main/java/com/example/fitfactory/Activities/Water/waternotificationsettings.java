package com.example.fitfactory.Activities.Water;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.fitfactory.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class waternotificationsettings extends AppCompatActivity {
    static int music1 = R .raw.caseclosed;

    static int music2 = R.raw.quick;
    static int music3 = R.raw.whistle;
    public int notificationchecked = 1;
    MediaPlayer player;
    MediaPlayer player2;
    MediaPlayer player3;
    int colorwhite = Color.parseColor("#FFFFFFFF");
    int color2 = Color.parseColor("#A8A8A8");
    Switch notificationswitch;
    Button savechanges;
    CircleImageView playstandardtone, playbingtone, playbeeptone;
    CardView standardcardview, bingcardview, wistlecardview;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waternotificationsettings);
        notificationswitch = findViewById(R.id.switch1);
        savechanges = findViewById(R.id.savewaterchanges);

        Log.d("notificationsettings", "onCreate: " + notificationswitch.isChecked());
        playstandardtone = findViewById(R.id.playstandardtone);
        playbingtone = findViewById(R.id.playbingtone);
        playbeeptone = findViewById(R.id.playbeeptone);
        standardcardview = findViewById(R.id.standardcardview);
        bingcardview = findViewById(R.id.Bingcardview);
        wistlecardview = findViewById(R.id.whistlecardview);
        notificationswitch.setChecked(true);
        loadnotificationstatus();
        savechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (notificationswitch.isChecked() == true) {
                    notificationchecked = 1;
                } else if (notificationswitch.isChecked() == false) {
                    notificationchecked = 0;
                }
                Log.d("watersettings", "onClick: " + notificationchecked);
                SharedPreferences sharedPreferences = getSharedPreferences("notificationchecked", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("notificationstatus", notificationchecked);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), waterreminder.class);
                startActivity(intent);
                finish();
            }
        });
        playstandardtone.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (player == null) {
                    player = MediaPlayer.create(getApplicationContext(), music1);
                }
                player.start();
                standardcardview.setCardBackgroundColor(color2);
                wistlecardview.setCardBackgroundColor(colorwhite);
                bingcardview.setCardBackgroundColor(colorwhite);
            }
        });
        playbeeptone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player2 == null) {
                    player2 = MediaPlayer.create(getApplicationContext(), music2);
                }
                player2.start();
                bingcardview.setCardBackgroundColor(color2);
                standardcardview.setCardBackgroundColor(colorwhite);
                wistlecardview.setCardBackgroundColor(colorwhite);
            }
        });
        playbingtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player3 == null) {
                    player3 = MediaPlayer.create(getApplicationContext(), music3);
                }
                player3.start();
                wistlecardview.setCardBackgroundColor(color2);
                bingcardview.setCardBackgroundColor(colorwhite);
                standardcardview.setCardBackgroundColor(colorwhite);
            }
        });
    }

    void loadnotificationstatus() {
        SharedPreferences getvalue = getSharedPreferences("notificationchecked", MODE_PRIVATE);
        notificationchecked = getvalue.getInt("notificationstatus", MODE_PRIVATE);
        Log.d("watersettings", "loadnotificationstatus: " + notificationchecked);
        if (notificationchecked == 1) {
            notificationswitch.setChecked(true);
        } else if (notificationchecked == 0) {
            notificationswitch.setChecked(false);
        }
    }

}