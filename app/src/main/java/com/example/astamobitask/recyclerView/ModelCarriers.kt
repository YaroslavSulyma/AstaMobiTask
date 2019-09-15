package com.example.astamobitask.recyclerView

sealed class ModelCarriers {

    data class Base (
        val worker : List<Worker>,
        val data : List<Data>
    )

    data class Worker (
        val success : Boolean,
        val errors : String,
        val data : List<String>
    )

    data class Data(
        val avatar: String,
        val name: String,
        val uid: String,
        val ratingSpeed: Double,
        val numberOfOrders: Int,
        val numberOfOrdersComplete: Int,
        val ratingPunctuality: Double,
        val workSchedule: WorkSchedule,
        val services: List<Services>
    )

    data class WorkSchedule (
        val endTime : String,
        val startTime : String,
        val dayOfWeek : List<Int>
    )

    data class Services (
        val id : String,
        val number : Int,
        val label : String
    )

}
