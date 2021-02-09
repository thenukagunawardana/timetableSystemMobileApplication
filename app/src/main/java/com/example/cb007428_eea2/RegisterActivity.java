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
import com.example.cb007428_eea2.Model.RegistrationDTO;
import com.example.cb007428_eea2.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity
{
    private EditText firstName,lastName,email_register,password_register,roles_register;
    private Button submitBtn,loginBtn;
    private TimetableApi timetableApi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName=findViewById(R.id.firstName_reg);
        lastName=findViewById(R.id.lastName_reg);
        email_register=findViewById(R.id.email_reg);
        password_register=findViewById(R.id.password_reg);
        roles_register=findViewById(R.id.roles_reg);
        submitBtn=findViewById(R.id.submitButton_reg);
        loginBtn=findViewById(R.id.loginButton_reg);

        submitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              User user=new User();

              user.setFirstName(firstName.getText().toString());
              user.setLastName(lastName.getText().toString());
              user.setEmail(email_register.getText().toString());
              user.setPassword(password_register.getText().toString());
              user.setRoles(roles_register.getText().toString());

                timetableApi= APIClient.getClient().create(TimetableApi.class);

                Call<LoginResponse>call=timetableApi.RegisterUser(user);
                call.enqueue(new Callback<LoginResponse>()
                {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response)
                    {
                        Toast.makeText(RegisterActivity.this,"Successfully Registered",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t)
                    {
                        Toast.makeText(RegisterActivity.this,"Failed to Save User: "+t,
                                Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}