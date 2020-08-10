package com.`fun`.testmvvmproject.repositry

import androidx.lifecycle.MutableLiveData
import java.util.*

class DayMessageRepository {

    private var dayMessageRepository: DayMessageRepository? = null
    private var message: MutableLiveData<String>? = null

    init {
        message = MutableLiveData();
    }

    fun getInstance(): DayMessageRepository {
        if (dayMessageRepository == null) {
            dayMessageRepository = DayMessageRepository()
        }
        return dayMessageRepository!!;
    }

    fun getDayTimeMessage() : DayMessageRepository{
        val c = Calendar.getInstance()
        message!!.value = when (c.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> "Good Morning"
            in 12..15 -> "Good Afternoon"
            in 16..20 -> "Good Evening"
            in 21..23 -> "Good Night"
            else -> "Hello"
        }
        return this
    }

    fun getDayMessage(): MutableLiveData<String> {
        return message!!
    }
}