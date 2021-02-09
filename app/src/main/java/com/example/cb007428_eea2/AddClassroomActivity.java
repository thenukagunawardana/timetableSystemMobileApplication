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
import com.example.cb007428_eea2.Model.Classroom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddClassroomActivity extends AppCompatActivity
{
    private EditText classRoom;
    private Button submitClassBtn,classroomBackBtn;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classroom);

        classRoom= findViewById(R.id.classroom_name);
        classroomBackBtn = findViewById(R.id.classroomBack_btn);
        submitClassBtn = findViewById(R.id.addClassroom_button);

        submitClassBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Classroom classroom = new Classroom();

                classroom.setClassName(classRoom.getText().toString());
                timetableApi = APIClient.getClient().create(TimetableApi.class);
                Call<LoginResponse> call = timetableApi.SaveClassroom(classroom);
                call.enqueue(new Callback<LoginResponse>()
                {

                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(AddClassroomActivity.this, "Successfully Added Classroom", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        Toast.makeText(AddClassroomActivity.this, "Failed to Add Classroom: "+t, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}