package com.`fun`.testmvvmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.`fun`.testmvvmproject.repositry.DayMessageRepository

class DayMessageViewModel : ViewModel() {

    private var dayMessageRepository: DayMessageRepository? = null
    private var message: MutableLiveData<String>? = null

    init {
        dayMessageRepository = DayMessageRepository().getInstance().getDayTimeMessage()
        message = dayMessageRepository!!.getDayMessage()
    }

    fun getDayMessage(): MutableLiveData<String> {
        return message!!
    }

}