package com.example.cb007428_eea2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Classroom
{
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("className")
    @Expose
    private String className;

    public Classroom()
    {

    }

    public Classroom(int id, String className)
    {
        this.id = id;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
