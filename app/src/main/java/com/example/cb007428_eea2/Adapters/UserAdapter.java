package com.example.cb007428_eea2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cb007428_eea2.Model.User;
import com.example.cb007428_eea2.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final List<User> users;
    private final Context context;

    public UserAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.user_headers,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.userID.setText(String.valueOf(users.get(position).getUserID()));
        holder.firstName.setText(users.get(position).getFirstName());
        holder.lastName.setText(users.get(position).getLastName());
        holder.email.setText(users.get(position).getEmail());
        holder.role.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView userID;
        private final TextView firstName;
        private final TextView lastName;
        private final TextView email;
        private final TextView role;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            userID=itemView.findViewById(R.id.userID_header);
            firstName=itemView.findViewById(R.id.firstName_header);
            lastName=itemView.findViewById(R.id.lastName_header);
            email=itemView.findViewById(R.id.email_header);
            role=itemView.findViewById(R.id.role_header);

        }
    }
}