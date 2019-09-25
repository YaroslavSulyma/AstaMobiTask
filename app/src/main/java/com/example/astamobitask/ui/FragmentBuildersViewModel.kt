package com.example.astamobitask.ui

import androidx.lifecycle.ViewModel
import com.example.astamobitask.manager.ITAInternetManager
import com.example.astamobitask.manager.response.CarrierResponse
import com.example.astamobitask.ui.carrierFragment.ItemsInterface
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Data
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Services
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.WorkSchedule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentBuildersViewModel: ViewModel() {

    private val internetManager = ITAInternetManager.instance
    var viewModel: ItemsInterface? = null

    fun initLoad() {
        internetManager.listBuilders().enqueue(object : Callback<CarrierResponse> {
            override fun onFailure(call: Call<CarrierResponse>, t: Throwable) {
                viewModel?.loadError(t.message!!)
            }

            override fun onResponse(
                call: Call<CarrierResponse>,
                response: Response<CarrierResponse>
            ) {
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
                    )
                    carrierList.add(carrierData)
                }
                viewModel?.loadFinished(carrierList)
            }
        })
    }
}