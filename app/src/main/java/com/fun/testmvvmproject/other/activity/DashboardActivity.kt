package com.`fun`.testmvvmproject.other.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.`fun`.testmvvmproject.R
import com.`fun`.testmvvmproject.repositry.DayMessageRepository
import com.`fun`.testmvvmproject.utils.USER_EMAIL
import com.`fun`.testmvvmproject.viewmodel.DayMessageViewModel
import com.`fun`.testmvvmproject.viewmodel.ProblemViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboardActivity : AppCompatActivity() {

    var dayMessageViewModel: DayMessageViewModel? = null
    var problemViewModel:ProblemViewModel?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)

        //var intent = intent
        //var emailAddress = intent.extras?.getString(USER_EMAIL)
        //text_email.text = emailAddress

        dayMessageViewModel = ViewModelProviders.of(this).get(DayMessageViewModel::class.java)
        dayMessageViewModel!!.getDayMessage().observe(this, Observer {
            text_geetings.text = it
        })


        problemViewModel = ViewModelProviders.of(this ).get(ProblemViewModel::class.java)
        problemViewModel!!.getProblem().observe(this , Observer {
            Log.d("SHOW" , ""+it.problems[0].diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0].name)
        })

    }
}