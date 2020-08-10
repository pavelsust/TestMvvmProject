package com.`fun`.testmvvmproject.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.`fun`.testmvvmproject.model.ProblemResponse
import com.`fun`.testmvvmproject.repositry.ProblemRepository

class ProblemViewModel(application: Application) : AndroidViewModel(application) {

    private var problemRepository: ProblemRepository? = null
    private var problemResponse: MutableLiveData<ProblemResponse>? = null

    init {
        problemRepository =
            ProblemRepository(application.applicationContext).getInstance().getResponse()
        problemResponse = problemRepository!!.getProblemResponse()
    }

    fun getProblem(): MutableLiveData<ProblemResponse> {
        return problemResponse!!
    }

}