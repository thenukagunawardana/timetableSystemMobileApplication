package com.example.cb007428_eea2.LoginResponse;

import com.example.cb007428_eea2.Model.Role;
import com.example.cb007428_eea2.Model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse
{
    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Role")
    @Expose
    private List<Role> role = null;
    @SerializedName("user")
    @Expose
    private User user;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
