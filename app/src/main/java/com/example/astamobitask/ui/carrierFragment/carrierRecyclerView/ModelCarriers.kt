package com.example.astamobitask.ui.carrierFragment.carrierRecyclerView


data class Worker(
    val _success: Boolean,
    val _errors: String?,
    val _data: List<Data>
)

data class Data(
    var _avatar: String,
    var _name: String,
    var _uid: String,
    var _ratingSpeed: Double,
    var _numberOfOrders: Int,
    var _numberOfOrdersComplete: Int,
    var _ratingPunctuality: Double,
    var _workSchedule: WorkSchedule,
    var _services: List<Services>
)

data class WorkSchedule(
    var _endTime: String,
    var _startTime: String,
    var _dayOfWeek: List<Int>
)

data class Services(
    var _id: String,
    var _number: Int,
    var _label: String
)