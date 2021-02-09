package com.example.cb007428_eea2.Model;


import com.example.cb007428_eea2.Model.Role_.Role_;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {
    @SerializedName("roles")
    @Expose
    private List<Role_> roles = null;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("first_Name")
    @Expose
    private String firstName;
    @SerializedName("last_Name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("userID")
    @Expose
    private Integer userID;

    public List<Role_> getRoles() {
        return roles;
    }

    public void setRoles(List<Role_> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setRoles(String toString)
    {

    }
}
