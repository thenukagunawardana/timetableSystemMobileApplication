package com.example.cb007428_eea2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cb007428_eea2.Model.Batch;
import com.example.cb007428_eea2.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.ViewHolder>
{
    private final List<Batch> batches;
    private final Context context;

    public BatchAdapter(List<Batch> batches, Context context)
    {
        this.batches = batches;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.batch_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Batch batch = batches.get(position);
        holder.batchID.setText(String.valueOf(batch.getId()));
        holder.batchName.setText(batch.getBatchCode());
    }

    @Override
    public int getItemCount() {
        return batches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView batchID;
        private final TextView batchName;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            batchID=itemView.findViewById(R.id.batchID_row);
            batchName=itemView.findViewById(R.id.batchName_row);
        }
    }
}
