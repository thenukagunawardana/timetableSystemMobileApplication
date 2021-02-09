package com.example.cb007428_eea2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cb007428_eea2.Model.Module;
import com.example.cb007428_eea2.R;

import java.util.ArrayList;
import java.util.List;

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
    private final List<Module> modules;
    private final Context context;

    public ModuleAdapter(List<Module> modules, Context context) {
        this.modules = modules;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.module_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.module_id.setText(String.valueOf(modules.get(position).getId()));
        holder.moduleName.setText(modules.get(position).getModule_name());
    }

    @Override
    public int getItemCount()
    {
        return modules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView module_id;
        private final TextView moduleName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            module_id = itemView.findViewById(R.id.module_id_row);
            moduleName = itemView.findViewById(R.id.module_name_row);
        }
    }
}
