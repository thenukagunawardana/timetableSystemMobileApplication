package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.LoginResponse.LoginResponse;
import com.example.cb007428_eea2.Model.Module;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddModuleActivity extends AppCompatActivity
{
    private EditText moduleName;
    private Button addModuleButton,backButton;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);

        moduleName=findViewById(R.id.moduleName);
        addModuleButton=findViewById(R.id.add_module);
        backButton=findViewById(R.id.moduleBackBTN);

        addModuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Module module= new Module();
                module.setModule_name(moduleName.getText().toString());
                timetableApi = APIClient.getClient().create(TimetableApi.class);
                Call<LoginResponse>call=timetableApi.SaveModule(module);
                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(AddModuleActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        Toast.makeText(AddModuleActivity.this, "Failed to Add Module: "+t
                                , Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
    }
}