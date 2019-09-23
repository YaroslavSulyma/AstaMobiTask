package com.example.astamobitask.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.astamobitask.manager.ITAInternetManager
import com.example.astamobitask.manager.response.CarrierResponse
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Data
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Services
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.WorkSchedule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ItemsInterface {
    fun loadFinished(response: ArrayList<Data>)
    fun loadError(error: String)
}

class FragmentCarriersViewModel : ViewModel() {

    private val internetManager = ITAInternetManager() /*= ITAInternetManager.instance*/
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
                val carrierList = ArrayList<Data>()
                response.body()?.data?.forEach {
                    val carrierData = Data(
                        _avatar = it.avatar,
                        _name = it.name,
                        _uid = it.uid,
                        _ratingSpeed = it.ratingSpeed,
                        _numberOfOrders = it.numberOfOrders,
                        _numberOfOrdersComplete = it.numberOfOrdersComplete,
                        _ratingPunctuality = it.ratingPunctuality,
                        _workSchedule = WorkSchedule(
                            _dayOfWeek = it.workSchedule.dayOfWeek,
                            _endTime = it.workSchedule.endTime,
                            _startTime = it.workSchedule.startTime
                        ),
                        _services = listOf(
                            Services(
                                _id = it.services[0].id,
                                _label = it.services[0].label,
                                _number = it.services[0].number
                            ),
                            Services(
                                _id = it.services[1].id,
                                _label = it.services[1].label,
                                _number = it.services[1].number
                            )
                        )
                    )/*
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

                    }*/
                    carrierList.add(carrierData)
                }
                viewModel?.loadFinished(carrierList)
            }
        })
    }
}