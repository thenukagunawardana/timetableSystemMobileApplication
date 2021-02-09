package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.Adapters.UserAdapter;
import com.example.cb007428_eea2.Model.Timetable;
import com.example.cb007428_eea2.Model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewUsersActivity extends AppCompatActivity
{
    private List<User> users;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        recyclerView=findViewById(R.id.users_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewUsersActivity.this));

        timetableApi= APIClient.getClient().create(TimetableApi.class);
        Call<List<User>> call=timetableApi.getAllUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response)
            {
                users=response.body();
                userAdapter=new UserAdapter(users,viewUsersActivity.this);
                recyclerView.setAdapter(userAdapter);
                Toast.makeText(viewUsersActivity.this,"Success: ",Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t)
            {
                Toast.makeText(viewUsersActivity.this,"Failure: ",Toast.LENGTH_SHORT).show();

            }
        });
    }
}