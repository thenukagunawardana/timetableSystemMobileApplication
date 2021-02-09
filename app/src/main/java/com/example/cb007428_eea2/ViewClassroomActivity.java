package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.Adapters.BatchAdapter;
import com.example.cb007428_eea2.Adapters.ClassroomAdapter;
import com.example.cb007428_eea2.Adapters.ModuleAdapter;
import com.example.cb007428_eea2.Model.Classroom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewClassroomActivity extends AppCompatActivity
{
    private TimetableApi timetableApi;
    private List<Classroom> classrooms;
    private RecyclerView recyclerView;
    private ClassroomAdapter classroomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_classroom);

        recyclerView = findViewById(R.id.classroom_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewClassroomActivity.this));

        timetableApi = APIClient.getClient().create(TimetableApi.class);
        Call<List<Classroom>> call = timetableApi.getAllClassrooms();

        call.enqueue(new Callback<List<Classroom>>()
        {

            @Override
            public void onResponse(Call<List<Classroom>> call, Response<List<Classroom>> response)
            {
                classrooms=response.body();
                classroomAdapter = new ClassroomAdapter(ViewClassroomActivity.this, classrooms);
                recyclerView.setAdapter(classroomAdapter);

                Toast.makeText(ViewClassroomActivity.this, "Page Loaded", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Classroom>> call, Throwable t)
            {
                Toast.makeText(ViewClassroomActivity.this, "Failed to load page: "+t, Toast.LENGTH_SHORT).show();

            }
        });
    }
}