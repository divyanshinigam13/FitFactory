package com.example.fitfactory.Activities.AllPosture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.fitme.Activities.ASANA.Pranayaam;
import com.example.fitme.Activities.ASANA.chakraasana;
import com.example.fitme.Activities.ASANA.paschimottanasana;
import com.example.fitme.Activities.ASANA.trikonasana;
import com.example.fitme.Activities.ASANA.virabhadraasana;
import com.example.fitme.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class recommendedpostures extends Fragment {
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    View view;
    String emialaddress;
    ProgressBar recommendedposturesprogressbar;
    String username1;
    CardView vajraasana, shavasana, gomukhasana, vrikshaasana, paschimottaasana, pranayama, charkasana, hastuttanasana, vibhadrasana, tadasana, bhujangasana, trikonsana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recommendedpostures, container, false);
        recommendedposturesprogressbar = view.findViewById(R.id.recommendedposturesprogressbar);
        trikonsana = (CardView) view.findViewById(R.id.trikonasanacardview);
        bhujangasana = (CardView) view.findViewById(R.id.bhujangasanacardview);
        tadasana = (CardView) view.findViewById(R.id.tadasanacardview);
        vibhadrasana = (CardView) view.findViewById(R.id.virabhadraasanacardview);
        charkasana = (CardView) view.findViewById(R.id.hastuttanasanacardview);
        hastuttanasana = (CardView) view.findViewById(R.id.chakraasanacardview);
        pranayama = (CardView) view.findViewById(R.id.pranayamcardview);
        paschimottaasana = (CardView) view.findViewById(R.id.paschimottanasanacardview);
        vrikshaasana = (CardView) view.findViewById(R.id.vrikshaasanacardview);
        vajraasana = (CardView) view.findViewById(R.id.vajrasanacardview);
        shavasana = (CardView) view.findViewById(R.id.shavasanacardview);
        gomukhasana = (CardView) view.findViewById(R.id.gomukhasanacardview);
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
                        Log.i("LOGGER", "string " + username1);
                        List<String> group = (List<String>) document.get("medicaldetails");
                        int arraylength = group.size();
                        for (int i = 0; i < arraylength; i++) {
                            Log.d("diseasename", "onComplete: " + group.get(i));
                            if (group.get(i).equals("Cancer")) {
                                Activity act = (Activity) getContext();
                                act.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        vajraasana.setVisibility(View.VISIBLE);
                                        vrikshaasana.setVisibility(View.VISIBLE);
                                    }
                                });
                            } else if (group.get(i).equals("Stroke")) {
                                tadasana.setVisibility(View.VISIBLE);
                                vibhadrasana.setVisibility(View.VISIBLE);
                            } else if (group.get(i).equals("Diabetes")) {
                                shavasana.setVisibility(View.VISIBLE);
                                paschimottaasana.setVisibility(View.VISIBLE);
                            } else if (group.get(i).equals("Spinal Injury")) {
                                trikonsana.setVisibility(View.VISIBLE);
                                bhujangasana.setVisibility(View.VISIBLE);
                            } else if (group.get(i).equals("Heart Problem")) {
                                gomukhasana.setVisibility(View.VISIBLE);
                                pranayama.setVisibility(View.VISIBLE);
                            } else if (group.get(i).equals("Respiratory problem")) {
                                charkasana.setVisibility(View.VISIBLE);
                                pranayama.setVisibility(View.VISIBLE);
                            }
                            recommendedposturesprogressbar.setVisibility(View.GONE);
                        }
                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }
        });
        vajraasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.vajraasana.class);
                startActivity(intent);
            }
        });
        shavasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.shavasana.class);
                startActivity(intent);
            }
        });
        gomukhasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.gomukhasana.class);
                startActivity(intent);
            }
        });
        vrikshaasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.vrikshaasana.class);
                startActivity(intent);
            }
        });
        paschimottaasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), paschimottanasana.class);
                startActivity(intent);
            }
        });
        pranayama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Pranayaam.class);
                startActivity(intent);
            }
        });
        hastuttanasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), chakraasana.class);
                startActivity(intent);
            }
        });
        charkasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.hastuttanasana.class);
                startActivity(intent);
            }
        });
        vibhadrasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), virabhadraasana.class);
                startActivity(intent);
            }
        });
        tadasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.tadasana.class);
                startActivity(intent);
            }
        });
        bhujangasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitme.Activities.ASANA.bhujangasana.class);
                startActivity(intent);
            }
        });
        trikonsana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), trikonasana.class);
                startActivity(intent);
            }
        });

        return view;
    }
}