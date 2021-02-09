package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class AdminActivity extends AppCompatActivity {
    private Button timetable_button, module_button, batch_button, classrooms_button,
            users_button, logout_button;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        timetable_button = findViewById(R.id.timetable_admin);
        module_button = findViewById(R.id.module_admin);
        batch_button = findViewById(R.id.batch_admin);
        classrooms_button = findViewById(R.id.classroom_admin);
        users_button = findViewById(R.id.users_admin);
        logout_button = findViewById(R.id.logout_admin);

        timetable_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminActivity.this, TimetableActivity.class);
                startActivity(intent);
            }
        });

        module_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, ModuleActivity.class);
                AdminActivity.this.startActivity(intent);
            }
        });

        batch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, BatchActivity.class);
                AdminActivity.this.startActivity(intent);
            }
        });
        classrooms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, ClassroomActivity.class);
                AdminActivity.this.startActivity(intent);
            }
        });

        users_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, viewUsersActivity.class);
                AdminActivity.this.startActivity(intent);
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                AdminActivity.this.startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}