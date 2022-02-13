package com.example.fitfactory.Activities.Bmi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitfactory.R;


import java.util.ArrayList;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {
    ArrayList<BmiCalculator.Menu> menuArrayList;
    Context context;

    public ChartAdapter(ArrayList<BmiCalculator.Menu> menuArrayList, Context context) {
        this.menuArrayList = menuArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chart_print, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BmiCalculator.Menu menu = menuArrayList.get(position);
        holder.time.setText(menu.getTime());
        holder.menu.setText(menu.getMenu());

    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time, menu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time1);
            menu = itemView.findViewById(R.id.menu);
        }
    }
}
