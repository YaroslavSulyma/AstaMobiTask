package com.example.astamobitask.manager.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WorkerResponse implements Serializable {

    @SerializedName("data")
    public List<DataItem> data;

    @SerializedName("success")
    public Boolean success;

    @SerializedName("errors")
    public String errors;
}