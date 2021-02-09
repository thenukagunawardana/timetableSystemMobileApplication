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
import com.example.cb007428_eea2.Model.Timetable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTimetableActivity extends AppCompatActivity
{
    private EditText addBatch,addModuleName,addStartTime,addLecturer,addDate,addClassroom;
    private Button submitTimetableBtn,timetableBackBtn;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timetable);

        addBatch=findViewById(R.id.addBatch_timetable);
        addModuleName=findViewById(R.id.addModule_timetable);
        addStartTime=findViewById(R.id.addStartTime_timetable);
        addLecturer=findViewById(R.id.addLecturer_timetable);
        addDate=findViewById(R.id.addDate_timetable);
        addClassroom=findViewById(R.id.addClassroom_timetable);
        submitTimetableBtn=findViewById(R.id.add_timetable_btn);
        timetableBackBtn=findViewById(R.id.backButton_timetable);

        submitTimetableBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Timetable timetable= new Timetable();
                timetable.setBatchName(addBatch.getText().toString());
                timetable.setModuleName(addModuleName.getText().toString());
                timetable.setStartTime(addStartTime.getText().toString());
                timetable.setLecturer(addLecturer.getText().toString());
                timetable.setDate(addDate.getText().toString());
                timetable.setClassRoom(addClassroom.getText().toString());
                timetableApi= APIClient.getClient().create(TimetableApi.class);
                Call<LoginResponse> call=timetableApi.saveTimetable(timetable);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(AddTimetableActivity.this, "Successfully Added Timetable", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        Toast.makeText(AddTimetableActivity.this, "Failed to Add timetable: "+t, Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });
    }
}