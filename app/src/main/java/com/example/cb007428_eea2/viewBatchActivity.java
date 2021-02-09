package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.Adapters.BatchAdapter;
import com.example.cb007428_eea2.Model.Batch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class viewBatchActivity extends AppCompatActivity
{
    private TimetableApi timetableApi;
    private List<Batch> batches;
    private RecyclerView recyclerView;
    private BatchAdapter batchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_batch);

        recyclerView = findViewById(R.id.batch_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewBatchActivity.this));
        timetableApi = APIClient.getClient().create(TimetableApi.class);

        Call<List<Batch>> call = timetableApi.getAllBatch();
        call.enqueue(new Callback<List<Batch>>() {
            @Override
            public void onResponse(Call<List<Batch>> call, Response<List<Batch>> response)
            {
                batches = response.body();
                batchAdapter = new BatchAdapter(batches, viewBatchActivity.this);
                recyclerView.setAdapter(batchAdapter);
                Toast.makeText(viewBatchActivity.this, "Page Loaded", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Batch>> call, Throwable t)
            {
                Toast.makeText(viewBatchActivity.this, "Failed to load page:"+t, Toast.LENGTH_SHORT).show();


            }
        });
    }
}