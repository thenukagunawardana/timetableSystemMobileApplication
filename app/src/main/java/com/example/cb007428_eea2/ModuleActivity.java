package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cb007428_eea2.API.TimetableApi;

public class ModuleActivity extends AppCompatActivity
{
    private Button add_module,view_modules;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        add_module = findViewById(R.id.add_module_home);
        view_modules = findViewById(R.id.view_module_home);

        add_module.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ModuleActivity.this, AddModuleActivity.class);
                ModuleActivity.this.startActivity(intent);

            }
        });
        view_modules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModuleActivity.this, ViewModuleActivity.class);
                ModuleActivity.this.startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}