package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class StudentActivity extends AppCompatActivity
{
    private Button viewTimetable_student,viewModules_student;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        viewTimetable_student=findViewById(R.id.view_timetable_student);
        viewModules_student=findViewById(R.id.view_modules_student);

        viewTimetable_student.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(StudentActivity.this, viewTimetableActivity.class);
                StudentActivity.this.startActivity(intent);
            }
        });

        viewModules_student.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(StudentActivity.this, ViewModuleActivity.class);
                StudentActivity.this.startActivity(intent);
            }
        });
    }
}