package com.example.rkuplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapternotify extends RecyclerView.Adapter<MyAdapternotify.ViewHolder> {

    private ArrayList<Modelnotify>modelArrayList;
    private Context context;

    public MyAdapternotify(ArrayList<Modelnotify> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_fetch,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Modelnotify model= modelArrayList.get(position);
        holder.Name.setText(model.getName() + "\n");
        holder.Date.setText(model.getDate()+"\n");
        holder.Time.setText(model.getTime()+"\n");
        holder.Venue.setText(model.getVenue()+"\n");


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Id,Name,Date,Time,Venue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Date = itemView.findViewById(R.id.Date);
            Time = itemView.findViewById(R.id.Time);
            Venue = itemView.findViewById(R.id.Venue);


        }
    }
}
