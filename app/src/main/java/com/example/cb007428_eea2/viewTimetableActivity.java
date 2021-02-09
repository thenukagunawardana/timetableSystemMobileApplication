package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.Adapters.TimetableAdapter;
import com.example.cb007428_eea2.Model.Timetable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewTimetableActivity extends AppCompatActivity
{
    private TimetableApi timetableApi;
    private ArrayList<Timetable> timetables=new ArrayList<>();
    private RecyclerView recyclerView;
    private TimetableAdapter timetableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_timetable);
        recyclerView = findViewById(R.id.timetable_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewTimetableActivity.this));

        timetableApi = APIClient.getClient().create(TimetableApi.class);
        Call<List<Timetable>> call = timetableApi.getAllTimetable();

        call.enqueue(new Callback<List<Timetable>>() {
            @Override
            public void onResponse(Call<List<Timetable>> call, Response<List<Timetable>> response)
            {
                timetables = new ArrayList<>(response.body());
                timetableAdapter = new TimetableAdapter(timetables, viewTimetableActivity.this);
                recyclerView.setAdapter(timetableAdapter);
                Toast.makeText(viewTimetableActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Timetable>> call, Throwable t)
            {
                Toast.makeText(viewTimetableActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}