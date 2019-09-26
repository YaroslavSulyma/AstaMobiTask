package com.example.astamobitask.manager

import com.example.astamobitask.manager.response.WorkerResponse
import retrofit2.Call
import retrofit2.http.GET

interface ITAService {
    @GET("https://api.myjson.com/bins/1fu47l/")
    fun listCarriers(): Call<WorkerResponse>

    @GET("https://api.myjson.com/bins/1h6bml")
    fun listBuilders(): Call<WorkerResponse>

    @GET("https://api.myjson.com/bins/1fu47l/")
    fun listLoaders(): Call<WorkerResponse>
}