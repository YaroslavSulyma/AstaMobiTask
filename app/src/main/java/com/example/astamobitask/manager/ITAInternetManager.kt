package com.example.astamobitask.manager

import com.example.astamobitask.manager.response.WorkerResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ITAInternetManager private constructor() : ITAService {
    override fun listBuilders(): Call<WorkerResponse> {
        return service.listBuilders()
    }

    override fun listLoaders(): Call<WorkerResponse> {
        return service.listLoaders()
    }

    override fun listCarriers(): Call<WorkerResponse> {
        return service.listCarriers()
    }

    private var service: ITAService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/1fu47l/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<ITAService>(ITAService::class.java)
    }

    private object Holder {
        val INSTANCE = ITAInternetManager()
    }

    companion object {
        val instance: ITAInternetManager by lazy { Holder.INSTANCE }
    }
}