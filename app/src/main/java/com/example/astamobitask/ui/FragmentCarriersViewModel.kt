package com.example.astamobitask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.astamobitask.manager.ITAInternetManager
import com.example.astamobitask.manager.response.CarrierResponse
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Data
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Worker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ItemsInterface {
    fun loadFinished(response: ArrayList<Worker>)
    fun loadError(error: String)
}

class FragmentCarriersViewModel : ViewModel() {

    private val internetManager: ITAInternetManager = ITAInternetManager.instance
    var viewModel: ItemsInterface? = null

    fun initLoad() {
        internetManager.listCarriers().enqueue(object : Callback<CarrierResponse> {
            override fun onFailure(call: Call<CarrierResponse>, t: Throwable) {
                viewModel?.loadError(t.message!!)
                Log.d("Parse", "onFailure")
            }

            override fun onResponse(
                call: Call<CarrierResponse>,
                response: Response<CarrierResponse>
            ) {
                Log.d("Parse", "onResponse")
                val carrierList = ArrayList<Worker>()
                response.body()?.data?.forEach {
                    lateinit var carrierData: Data
                    carrierData._name = it.name
                    carrierData._avatar = it.avatar
                    carrierData._numberOfOrders = it.numberOfOrders
                    carrierData._numberOfOrdersComplete = it.numberOfOrdersComplete
                    carrierData._ratingPunctuality = it.ratingPunctuality
                    carrierData._ratingSpeed = it.ratingSpeed
                    carrierData._uid = it.uid
                    carrierData._workSchedule._dayOfWeek = it.workSchedule.dayOfWeek
                    carrierData._workSchedule._endTime = it.workSchedule.endTime
                    carrierData._workSchedule._startTime = it.workSchedule.startTime
                    for (i in carrierData._services.indices) {
                        carrierData._services[i]._id = it.services[i].id
                        carrierData._services[i]._label = it.services[i].label
                        carrierData._services[i]._number = it.services[i].number

                    }
                }
                viewModel?.loadFinished(carrierList)
            }
        })
    }
}