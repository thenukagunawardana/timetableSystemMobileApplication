package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class BatchActivity extends AppCompatActivity
{
    private Button addBatch,viewBatches;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch);

        addBatch=findViewById(R.id.add_Batch);
        viewBatches=findViewById(R.id.view_Batches);

        addBatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BatchActivity.this, AddBatchActivity.class);
                BatchActivity.this.startActivity(intent);
            }
        });

        viewBatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BatchActivity.this, viewBatchActivity.class);
                BatchActivity.this.startActivity(intent);
            }
        });

    }
}