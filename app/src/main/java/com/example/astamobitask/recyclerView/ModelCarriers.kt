package com.example.astamobitask.recyclerView


data class Worker(
        val _success: Boolean,
        val _errors: String?,
        val _data: List<Data>
) : IWorker {
    override fun getSuccess(): Boolean {
        return _success
    }

    override fun getErrors(): String? {
        return _errors
    }

    override fun getData(): List<Data> {
        return _data
    }
}

data class Data(
        val _avatar: String,
        val _name: String,
        val _uid: String,
        val _ratingSpeed: Double,
        val _numberOfOrders: Int,
        val _numberOfOrdersComplete: Int,
        val _ratingPunctuality: Double,
        val _workSchedule: WorkSchedule,
        val _services: List<Services>
) : IData {
    override fun getOrders(orders: Int, completedOrders: Int): String {
        return "$orders з $completedOrders"
    }

    override fun getAvatar(): String {
        return _avatar
    }

    override fun getName(): String {
        return _name
    }

    override fun getUid(): String {
        return _uid
    }

    override fun getRatingSpeed(): Double {
        return _ratingSpeed
    }

    override fun getNumberOfOrders(): Int {
        return _numberOfOrders
    }

    override fun getNumberOfOrdersComplete(): Int {
        return _numberOfOrdersComplete
    }

    override fun getRatingPunctuality(): Double {
        return _ratingPunctuality
    }

    override fun getWorkSchedule(): WorkSchedule {
        return _workSchedule
    }

    override fun getServices(): List<Services> {
        return _services
    }
}

data class WorkSchedule(
        val _endTime: String,
        val _startTime: String,
        val _dayOfWeek: List<Int>
) : IWorkSchedule {
    override fun getTime(startTime: String, endTime: String): String {
        return "$startTime - $endTime"
    }

    override fun getEndTime(): String {
        return _endTime
    }

    override fun getStartTime(): String {
        return _startTime
    }

    override fun getDayOfWeek(): List<Int> {
        return _dayOfWeek
    }

}

data class Services(
        val _id: String,
        val _number: Int,
        val _label: String
) : IServices {
    override fun getId(): String {
        return _id
    }

    override fun getNumber(): Int {
        return _number
    }

    override fun getLabel(): String {
        return _label
    }
}

interface IWorker {
    fun getSuccess(): Boolean
    fun getErrors(): String?
    fun getData(): List<Data>

}

interface IData {
    fun getAvatar(): String
    fun getName(): String
    fun getUid(): String
    fun getRatingSpeed(): Double
    fun getNumberOfOrders(): Int
    fun getNumberOfOrdersComplete(): Int
    fun getRatingPunctuality(): Double
    fun getWorkSchedule(): WorkSchedule
    fun getServices(): List<Services>
    fun getOrders(orders: Int = getNumberOfOrders(), completedOrders: Int = getNumberOfOrdersComplete()): String
}

interface IWorkSchedule {
    fun getEndTime(): String
    fun getStartTime(): String
    fun getDayOfWeek(): List<Int>
    fun getTime(startTime: String = getStartTime(), endTime: String = getEndTime()): String
}

interface IServices {
    fun getId(): String
    fun getNumber(): Int
    fun getLabel(): String
}

