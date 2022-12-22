package com.example.rkuplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Company Adapter
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Model>modelArrayList;
    private Context context;

    public MyAdapter(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.our_companies_fetch,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model= modelArrayList.get(position);
        holder.Name.setText(model.getName() + "\n");
        holder.job_location.setText(model.getJob_location()+"\n");
        holder.company_url.setText(model.getCompany_url()+"\n");
        holder.Package.setText(model.getPackage()+"\n");
        holder.Contract.setText(model.getContract()+"\n");
        holder.job_profile.setText(model.getJob_profile()+"\n");
        holder.date_joining.setText(model.getDate_joining()+"\n");
        holder.batch.setText(model.getBatch()+"\n");
        holder.eligible_course.setText(model.getEligible_course()+"\n");
        holder.registration_time.setText(model.getRegistration_time()+"\n");
        holder.company_profile.setText(model.company_profile+"\n");


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Id,Name,Job_Description,Contract,Package,Training_Time, job_location, company_url, ctc, job_profile, date_joining, img, batch, eligible_course, registration_time, Contact, venue, date_time, registration_link, company_profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            job_location = itemView.findViewById(R.id.job_location);
            company_url = itemView.findViewById(R.id.company_url);
            Package = itemView.findViewById(R.id.Package);
            Contract = itemView.findViewById(R.id.Contract);
            job_profile = itemView.findViewById(R.id.job_profile);
            date_joining = itemView.findViewById(R.id.date_joining);
            batch = itemView.findViewById(R.id.batch);
            eligible_course = itemView.findViewById(R.id.eligible_course);
            registration_time =itemView.findViewById(R.id.registration_time);
            company_profile = itemView.findViewById(R.id.company_profile);

        }
    }
}
