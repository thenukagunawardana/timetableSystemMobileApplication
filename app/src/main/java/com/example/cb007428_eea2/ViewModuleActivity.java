package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.Adapters.ModuleAdapter;
import com.example.cb007428_eea2.Model.Module;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModuleActivity extends AppCompatActivity
{
    private TimetableApi timetableApi;
    private List<Module> modules;
    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_module);

        recyclerView = findViewById(R.id.module_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewModuleActivity.this));

        timetableApi = APIClient.getClient().create(TimetableApi.class);
        Call<List<Module>> call = timetableApi.getAllModules();

        call.enqueue(new Callback<List<Module>>() {
            @Override
            public void onResponse(Call<List<Module>> call, Response<List<Module>> response) {
                modules=response.body();
                moduleAdapter = new ModuleAdapter(modules, ViewModuleActivity.this);
                recyclerView.setAdapter(moduleAdapter);
                Toast.makeText(ViewModuleActivity.this, "Page Loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Module>> call, Throwable t)
            {
                Toast.makeText(ViewModuleActivity.this, "Failed to Load page: "+t, Toast.LENGTH_SHORT).show();

            }
        });
    }

}