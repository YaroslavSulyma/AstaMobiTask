package com.example.astamobitask.manager.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class WorkSchedule implements Serializable {

    @SerializedName("dayOfWeek")
    public List<Integer> dayOfWeek;

    @SerializedName("startTime")
    public String startTime;

    @SerializedName("endTime")
    public String endTime;
}