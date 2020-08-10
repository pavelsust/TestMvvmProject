package com.`fun`.testmvvmproject.other.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.`fun`.testmvvmproject.R
import com.`fun`.testmvvmproject.adapter.DrugInformationAdapter
import com.`fun`.testmvvmproject.model.problem.DrugInformation
import com.`fun`.testmvvmproject.utils.USER_EMAIL
import com.`fun`.testmvvmproject.viewmodel.DayMessageViewModel
import com.`fun`.testmvvmproject.viewmodel.ProblemViewModel
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.content_dashboard.*


class DashboardActivity : AppCompatActivity() {

    var dayMessageViewModel: DayMessageViewModel? = null
    var problemViewModel: ProblemViewModel? = null

    var drugInformationList: MutableList<DrugInformation> = ArrayList();


    var drugInformationAdapter: DrugInformationAdapter? = null

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
        problemViewModel!!.init(applicationContext)
        problemViewModel!!.getProblem().observe(this, Observer {

            var result = it.problems[0].diabetes[0].medications[0].medicationsClasses[0]

            for (item in result.className) {
                for (associated in item.associatedDrug) {
                    drugInformationList.add(
                        DrugInformation(
                            associated.name,
                            associated.dose,
                            associated.strength
                        )
                    )
                }

                for (associated in item.associatedDrug_two) {
                    drugInformationList.add(
                        DrugInformation(
                            associated.name,
                            associated.dose,
                            associated.strength
                        )
                    )
                }
            }

            for (item in result.className_two) {
                for (associated in item.associatedDrug) {
                    drugInformationList.add(
                        DrugInformation(
                            associated.name,
                            associated.dose,
                            associated.strength
                        )
                    )
                }

                for (associated in item.associatedDrug_two) {
                    drugInformationList.add(
                        DrugInformation(
                            associated.name,
                            associated.dose,
                            associated.strength
                        )
                    )
                }

                showDrugInformationInList(drugInformationList as ArrayList<DrugInformation>)
            }
        })

    }

    private fun showDrugInformationInList(list: ArrayList<DrugInformation>) {

        drugInformationAdapter = DrugInformationAdapter(list)
        recycleview.layoutManager = LinearLayoutManager(applicationContext)

        val dividerItemDecoration = DividerItemDecoration(
            recycleview.context,
            LinearLayoutManager(applicationContext).orientation
        )
        recycleview.addItemDecoration(dividerItemDecoration)


        recycleview.adapter = drugInformationAdapter
    }
}