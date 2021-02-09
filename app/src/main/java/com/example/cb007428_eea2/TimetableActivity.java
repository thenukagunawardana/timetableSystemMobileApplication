package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

import java.sql.Time;

public class TimetableActivity extends AppCompatActivity
{
    private Button addTimetable, viewTimetable;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

//        addTimetable = findViewById(R.id.add_timetable_btn);
        viewTimetable = findViewById(R.id.view_Timetable);

//        addTimetable.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(TimetableActivity.this, AddTimetableActivity.class);
//                TimetableActivity.this.startActivity(intent);
//            }
//        });

        viewTimetable.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimetableActivity.this, viewTimetableActivity.class);
                TimetableActivity.this.startActivity(intent);
            }
        });

    }
}