package com.example.cb007428_eea2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cb007428_eea2.Model.Timetable;
import com.example.cb007428_eea2.R;

import java.util.ArrayList;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder>
{

    private ArrayList<Timetable> timetables = new ArrayList<>();
    private Context context;

    public TimetableAdapter(ArrayList<Timetable> timetables, Context context)
    {
        this.timetables = timetables;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.timetable_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.timetable_id.setText("ID: "+timetables.get(position).getId().toString());
        holder.batchname.setText(timetables.get(position).getBatchName());
        holder.modulename.setText(timetables.get(position).getModuleName());
        holder.date.setText(timetables.get(position).getDate());
        holder.startTime.setText(timetables.get(position).getStartTime());
        holder.classroom.setText(timetables.get(position).getClassRoom());
        holder.lecturer.setText(timetables.get(position).getLecturer());

    }

    @Override
    public int getItemCount() {
        return timetables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView timetable_id,batchname,modulename,date,startTime,classroom,lecturer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timetable_id = itemView.findViewById(R.id.timetableID);
            batchname = itemView.findViewById(R.id.batchCode_time);
            modulename = itemView.findViewById(R.id.module_time);
            date = itemView.findViewById(R.id.date_time);
            startTime = itemView.findViewById(R.id.startTime);
            classroom=itemView.findViewById(R.id.classroom_time);
            lecturer = itemView.findViewById(R.id.lecturer_time);
        }
    }
}

