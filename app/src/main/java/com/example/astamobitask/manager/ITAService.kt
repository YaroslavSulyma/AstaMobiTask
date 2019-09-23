package com.example.astamobitask.manager

import com.example.astamobitask.manager.response.CarrierResponse
import com.example.astamobitask.manager.response.DataItem
import retrofit2.Call
import retrofit2.http.GET


interface ITAService {
    @GET("http://localhost:8080/data")
    fun listCarriers(): Call<CarrierResponse>
}