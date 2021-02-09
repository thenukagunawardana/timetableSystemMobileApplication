package com.example.cb007428_eea2;

import
        androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.LoginResponse.LoginResponse;
import com.example.cb007428_eea2.Model.Batch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBatchActivity extends AppCompatActivity
{
    private EditText batchCode;
    private Button batchBackBtn,addBatchBtn;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_batch);

        batchCode= findViewById(R.id.addBatch_code);
        batchBackBtn = findViewById(R.id.batchBack_btn);
        addBatchBtn = findViewById(R.id.addBatch_button);

        addBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Batch batch = new Batch();
                batch.setBatchCode(batchCode.getText().toString());
                timetableApi = APIClient.getClient().create(TimetableApi.class);
                Call<LoginResponse> call = timetableApi.saveBatch(batch);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(AddBatchActivity.this, "Added Batch Successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(AddBatchActivity.this, "Failed to add batch: "+t, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}