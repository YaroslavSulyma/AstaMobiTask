package com.example.astamobitask.manager.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ServicesItem implements Serializable {

    @SerializedName("number")
    public Integer number;

    @SerializedName("id")
    public String id;

    @SerializedName("label")
    public String label;
}