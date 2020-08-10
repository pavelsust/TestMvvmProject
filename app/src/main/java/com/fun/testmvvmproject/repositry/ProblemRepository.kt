package com.`fun`.testmvvmproject.repositry

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.`fun`.testmvvmproject.model.ProblemResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ProblemRepository(context: Context) {

    private var problemRepository: ProblemRepository? = null
    private var problemResponse: MutableLiveData<ProblemResponse>? = null
    private var context: Context? = null

    init {
        this.context = context
        problemResponse = MutableLiveData()
    }

    fun getInstance(): ProblemRepository {
        if (problemRepository == null) {
            problemRepository = ProblemRepository(context!!)
        }
        return problemRepository!!
    }


    fun getResponse(): ProblemRepository {
        val jsonString: String
        try {
            jsonString =
                context!!.assets.open("problem.json").bufferedReader().use { it.readText() }

            val gson = Gson()
            val listProblem = object : TypeToken<ProblemResponse>() {}.type
            var problem: ProblemResponse = gson.fromJson(jsonString, listProblem)
            problemResponse!!.value = problem
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return this
    }

    fun getProblemResponse():MutableLiveData<ProblemResponse>{
        return problemResponse!!
    }

}