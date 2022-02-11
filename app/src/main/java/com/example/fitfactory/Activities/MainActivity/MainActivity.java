package com.example.fitfactory.Activities.MainActivity;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitfactory.Activities.Dashboard.dashboard_menu;
import com.example.fitfactory.R;
import com.example.fitfactory.Activities.emergency_portal;
import com.example.fitfactory.Activities.LoginAndStarting.user_profile;

public class MainActivity extends AppCompatActivity {

    Button home, emergency, userprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        home = findViewById(R.id.dashboardhome);
        emergency = findViewById(R.id.emergencybutton);
        userprofile = findViewById(R.id.userprofile);
        replaceFragment(new dashboard_menu());
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new dashboard_menu());
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new emergency_portal());
            }
        });
        userprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new user_profile());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dashboardframelayout, fragment);
        fragmentTransaction.commit();
    }
}
