package com.example.fitfactory.Activities.Bmi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitfactory.R;


import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categoryArrayList;
    Context context;

    public CategoryAdapter(ArrayList<Category> categoryArrayList, Context context) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_print, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categoryArrayList.get(position);
        holder.title.setText(category.getTitle());
        holder.range.setText(category.getRange());
        holder.image.setImageResource(category.getImageRec());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DietChart.class);
                intent.putExtra("TitleCheck", true);
                intent.putExtra("TitleSent", category.getTitle());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, range;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title1);
            range = itemView.findViewById(R.id.range);
            image = itemView.findViewById(R.id.image1);
        }
    }
}

