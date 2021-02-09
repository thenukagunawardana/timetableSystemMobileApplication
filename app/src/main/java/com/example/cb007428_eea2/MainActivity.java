package com.example.cb007428_eea2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cb007428_eea2.API.APIClient;
import com.example.cb007428_eea2.API.TimetableApi;
import com.example.cb007428_eea2.LoginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    private EditText email,password;
    private Button register_btn,login_btn;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        register_btn=findViewById(R.id.reg_btn);
        login_btn=findViewById(R.id.login_btn);

        register_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String mail=email.getText().toString();
                String pass=password.getText().toString();

                timetableApi= APIClient.getClient().create(TimetableApi.class);

                Call<LoginResponse>call=timetableApi.getLoginDetails(mail,pass);
                call.enqueue(new Callback<LoginResponse>()
                {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                    {
                        LoginResponse loginResponse=response.body();
                        loginResponse.getRole().get(0).getName();

                        if(loginResponse.getRole().get(0).getName().matches("Admin")){
                            Intent myIntent = new Intent(MainActivity.this, AdminActivity.class);
                            MainActivity.this.startActivity(myIntent);
                        }
                        else if(loginResponse.getRole().get(0).getName().matches("Student")){
                            Intent myIntent = new Intent(MainActivity.this, StudentActivity.class);
                            MainActivity.this.startActivity(myIntent);
                        }
                        else if(loginResponse.getRole().get(0).getName().matches("Lecturer"))
                        {
                            Intent myIntent = new Intent(MainActivity.this, LecturerActivity.class);
                            MainActivity.this.startActivity(myIntent);
                        }
                        Toast.makeText(MainActivity.this,"Role:  "+loginResponse.getRole().get(0).getName(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        Toast.makeText(MainActivity.this,"Failed: "+t,Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}