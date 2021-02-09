package com.example.cb007428_eea2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Module
{
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("module_name")
    @Expose
    private String module_name;

    public Module()
    {

    }

    public Module(int id, String module_name) {
        this.id = id;
        this.module_name = module_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }
}
