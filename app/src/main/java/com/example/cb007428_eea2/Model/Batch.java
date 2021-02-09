package com.example.cb007428_eea2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batch
{
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("batchCode")
    @Expose
    private String batchCode;

    public Batch() {

    }

    public Batch(int id, String batchCode) {
        this.id = id;
        this.batchCode = batchCode;
    }

    public long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }
}
