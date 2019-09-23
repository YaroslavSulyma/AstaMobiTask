package com.example.astamobitask.manager.response;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem implements Serializable {

	@SerializedName("numberOfOrdersComplete")
	public int numberOfOrdersComplete;

	@SerializedName("uid")
	public String uid;

	@SerializedName("ratingSpeed")
	public Double ratingSpeed;

	@SerializedName("workSchedule")
	public WorkSchedule workSchedule;

	@SerializedName("ratingPunctuality")
	public Double ratingPunctuality;

	@SerializedName("name")
	public String name;

	@SerializedName("avatar")
	public String avatar;

	@SerializedName("numberOfOrders")
	public Integer numberOfOrders;

	@SerializedName("services")
	public List<ServicesItem> services;
}