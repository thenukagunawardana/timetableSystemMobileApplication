package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class LecturerActivity extends AppCompatActivity
{
    private Button viewBatchesLec,viewModulesLec,viewClassrooms,addTimetableLec,logout;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer);

        viewBatchesLec=findViewById(R.id.view_batches_lec);
        viewModulesLec=findViewById(R.id.view_modules_lec);
        viewClassrooms=findViewById(R.id.view_classrooms_lec);
        addTimetableLec=findViewById(R.id.add_timetable_lec);
        logout=findViewById(R.id.logout_lecturer);

        viewBatchesLec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LecturerActivity.this, viewBatchActivity.class);
                LecturerActivity.this.startActivity(intent);
            }
        });

        viewModulesLec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                {
                    Intent intent = new Intent(LecturerActivity.this, ViewModuleActivity.class);
                    LecturerActivity.this.startActivity(intent);
                }
            }
        });

        viewClassrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LecturerActivity.this, ViewClassroomActivity.class);
                LecturerActivity.this.startActivity(intent);
            }
        });

        addTimetableLec.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LecturerActivity.this,AddTimetableActivity.class);
                LecturerActivity.this.startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent= new Intent(LecturerActivity.this, MainActivity.class);
                LecturerActivity.this.startActivity(intent);
            }
        });
        {

        }

    }
}