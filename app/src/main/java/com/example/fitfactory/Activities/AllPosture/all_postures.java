package com.example.fitfactory.Activities.AllPosture;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.fitfactory.Activities.ASANA.Pranayaam;
import com.example.fitfactory.Activities.ASANA.chakraasana;
import com.example.fitfactory.Activities.ASANA.paschimottanasana;
import com.example.fitfactory.Activities.ASANA.trikonasana;
import com.example.fitfactory.Activities.ASANA.virabhadraasana;
import com.example.fitfactory.R;


public class all_postures extends Fragment {

    View view;
    CardView vajraasana, shavasana, gomukhasana, vrikshaasana, paschimottaasana, pranayama, charkasana, hastuttanasana, vibhadrasana, tadasana, bhujangasana, trikonsana;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_all_postures, container, false);
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
        vajraasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.vajraasana.class);
                startActivity(intent);
            }
        });
        shavasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.shavasana.class);
                startActivity(intent);
            }
        });
        gomukhasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.gomukhasana.class);
                startActivity(intent);
            }
        });
        vrikshaasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.vrikshaasana.class);
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
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.hastuttanasana.class);
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
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.tadasana.class);
                startActivity(intent);
            }
        });
        bhujangasana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), com.example.fitfactory.Activities.ASANA.bhujangasana.class);
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