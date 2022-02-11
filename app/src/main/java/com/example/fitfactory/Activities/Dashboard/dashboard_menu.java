package com.example.fitfactory.Activities.Dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.fitfactory.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class dashboard_menu extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String username1;
    String emialaddress;
    View view;
    TextView datetext, welcomeuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Date currentTime = Calendar.getInstance().getTime();
        String formattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        CardView Yoga, mediation, waterreminder, dietplanner;
        TextView welcomeuser;
        ProgressBar dashboardprogressbar;
        view = inflater.inflate(R.layout.fragment_dashboard_menu, container, false);
        datetext = view.findViewById(R.id.datetext);
        dashboardprogressbar = view.findViewById(R.id.dashboardprogressbar);
        Yoga = view.findViewById(R.id.yoga);
        mediation = view.findViewById(R.id.meditation);
        welcomeuser=view.findViewById(R.id.welcomeuser);
        waterreminder=view.findViewById(R.id.waterreminder);
        dietplanner=view.findViewById(R.id.dietplanner);
        //Date and Time Display
        Log.d("myLOG", currentTime.toString());
        datetext.setText(formattedDate);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        emialaddress = fAuth.getCurrentUser().getEmail();

        DocumentReference documentReference = fStore.collection("users").document(emialaddress);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        Log.i("LOGGER", "First " + document.getString("username"));
                        username1 = (String) document.getString("username");
                        welcomeuser.setText("Welcome " + username1);
                        dashboardprogressbar.setVisibility(View.GONE);

                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }
        });
        return view;

    }

}