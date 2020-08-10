package com.`fun`.testmvvmproject.other.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.`fun`.testmvvmproject.R
import com.`fun`.testmvvmproject.utils.USER_EMAIL
import com.`fun`.testmvvmproject.viewmodel.DayMessageViewModel
import com.`fun`.testmvvmproject.viewmodel.ProblemViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*

class DashboardActivity : AppCompatActivity() {

    var dayMessageViewModel: DayMessageViewModel? = null
    var problemViewModel: ProblemViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener { finish() }


        var intent = intent
        var emailAddress = intent.extras?.getString(USER_EMAIL)
        text_email.text = "User Email: $emailAddress"

        dayMessageViewModel = ViewModelProviders.of(this).get(DayMessageViewModel::class.java)
        dayMessageViewModel!!.getDayMessage().observe(this, Observer {
            text_geetings.text = it
        })

        problemViewModel = ViewModelProviders.of(this).get(ProblemViewModel::class.java)
        problemViewModel!!.getProblem().observe(this, Observer {
            var item =
                it.problems[0].diabetes[0].medications[0].medicationsClasses[0].className[0].associatedDrug[0]

            text_drag.text =
                "Name: ${item.name}\n" + "Dose: ${item.dose}\n" + "Strength: ${item.strength}"

        })

    }
}