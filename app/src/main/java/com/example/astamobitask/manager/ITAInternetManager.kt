package com.example.astamobitask.manager

import com.example.astamobitask.manager.response.CarrierResponse
import com.example.astamobitask.manager.response.DataItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ITAInternetManager() : ITAService {

    override fun listCarriers(): Call<CarrierResponse> {
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