package com.example.cb007428_eea2.API;

import com.example.cb007428_eea2.LoginResponse.LoginResponse;
import com.example.cb007428_eea2.Model.Batch;
import com.example.cb007428_eea2.Model.Classroom;
import com.example.cb007428_eea2.Model.Module;
import com.example.cb007428_eea2.Model.RegistrationDTO;
import com.example.cb007428_eea2.Model.Timetable;
import com.example.cb007428_eea2.Model.User;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TimetableApi
{
    @POST("admin/saveClassroom")
    Call<LoginResponse> SaveClassroom(@Body Classroom classroom);

    @POST("admin/saveModule")
    Call<LoginResponse> SaveModule(@Body Module module);

    @GET("login/{email}/{pass}")
    Call<LoginResponse> getLoginDetails(@Path("email") String mail,
                                        @Path("pass") String pass);

    @POST("admin/saveBatch")
    Call<LoginResponse> saveBatch(@Body Batch batch);

    @POST("admin/saveTimetable")
    Call<LoginResponse> saveTimetable(@Body Timetable timetable);

    @POST("/register")
    Call<LoginResponse> RegisterUser(User user);

    @GET("timetables")
    Call<List<Timetable>> getAllTimetable();

    @GET("batches")
    Call<List<Batch>> getAllBatch();

    @GET("classrooms")
    Call<List<Classroom>> getAllClassrooms();

    @GET("modules")
    Call<List<Module>> getAllModules();

    @GET("users")
    Call<List<User>> getAllUsers();
}
