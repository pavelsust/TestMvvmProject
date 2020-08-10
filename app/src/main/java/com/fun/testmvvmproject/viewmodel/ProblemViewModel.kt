package com.`fun`.testmvvmproject.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.`fun`.testmvvmproject.model.ProblemResponse
import com.`fun`.testmvvmproject.repositry.ProblemRepository

class ProblemViewModel : ViewModel() {

    private var problemRepository: ProblemRepository? = null
    private var problemResponse: MutableLiveData<ProblemResponse>? = null

   fun init(context: Context) : ProblemViewModel{
        problemRepository =
            ProblemRepository(context.applicationContext).getInstance().getResponse()
        problemResponse = problemRepository!!.getProblemResponse()
       return this
    }

    fun getProblem(): MutableLiveData<ProblemResponse> {
        return problemResponse!!
    }

}