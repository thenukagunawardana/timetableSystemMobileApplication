package com.example.cb007428_eea2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cb007428_eea2.Model.Classroom;
import com.example.cb007428_eea2.R;
import com.example.cb007428_eea2.ViewClassroomActivity;

import java.util.List;

public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomAdapter.ViewHolder>
{
    private final Context context;
    private final List<Classroom>classrooms;

    public ClassroomAdapter(Context context, List<Classroom> classrooms)
    {
        this.context = context;
        this.classrooms = classrooms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View  view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.classroom_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.classID.setText(String.valueOf(classrooms.get(position).getId()));
        holder.className.setText(classrooms.get(position).getClassName());
    }

    @Override
    public int getItemCount()
    {
        return classrooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView classID;
        private final TextView className;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            classID=itemView.findViewById(R.id.classroom_ID_row);
            className=itemView.findViewById(R.id.classroom_row);
        }
    }
}
