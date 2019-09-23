package com.example.astamobitask.dummyContent

import android.util.Log
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Data
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Services
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.WorkSchedule
import com.example.astamobitask.ui.carrierFragment.carrierRecyclerView.Worker

object DummyData {
    private val dataList = ArrayList<Data>()
    private val carrierList = ArrayList<Worker>()

    fun getData(): List<Data> {
        dataList.add(
            Data(
                "https://www.thewrap.com/wp-content/uploads/2017/04/thor.jpg",
                "Thor",
                "hxmDLmU79DS8ihkHuMNo6HU3XcU2",
                3.5,
                2,
                2,
                3.5,
                WorkSchedule(
                    "21:00",
                    "08:00",
                    listOf(0, 1, 2, 3, 4)
                ),
                listOf(
                    Services(
                        "Qe5UrXeQBMZB3V1wJ6hf",
                        20,
                        "Ціна за час"
                    ),
                    Services(
                        "Qe5UrXeQBMZB3V1wJ7hf",
                        30,
                        "Ціна за км"
                    )
                )
            )
        )
        dataList.add(
            Data(
                "https://www.thewrap.com/wp-content/uploads/2017/04/thor.jpg",
                "Thor2",
                "hxmDLmU79DS8ihkHuMNo6HU3XcU2",
                3.5,
                2,
                2,
                3.5,
                WorkSchedule(
                    "21:00",
                    "08:00",
                    listOf(0, 1, 2, 3, 4)
                ),
                listOf(
                    Services(
                        "Qe5UrXeQBMZB3V1wJ6hf",
                        20,
                        "Ціна за час"
                    ),
                    Services(
                        "Qe5UrXeQBMZB3V1wJ7hf",
                        30,
                        "Ціна за км"
                    )
                )
            )
        )
        Log.d("Data", "$dataList")
        return dataList
    }

    fun getItemStatus(): List<Worker> {
        carrierList.add(
            Worker(
                true, null, dataList
            )
        )
        return carrierList
    }
}


