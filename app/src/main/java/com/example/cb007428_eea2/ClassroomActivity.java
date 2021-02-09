package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class ClassroomActivity extends AppCompatActivity
{
    private Button addClassroom,viewClassrooms;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);

        addClassroom=findViewById(R.id.add_Classroom);
        viewClassrooms=findViewById(R.id.view_Classrooms);

        addClassroom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ClassroomActivity.this, AddClassroomActivity.class);
                ClassroomActivity.this.startActivity(intent);
            }
        });

        viewClassrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassroomActivity.this, ViewClassroomActivity.class);
                ClassroomActivity.this.startActivity(intent);
            }
        });
    }
}