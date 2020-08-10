package com.`fun`.testmvvmproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.`fun`.testmvvmproject.R
import com.`fun`.testmvvmproject.custom.font.MyTextViewMeriendaRegular
import com.`fun`.testmvvmproject.model.problem.DrugInformation
import kotlinx.android.synthetic.main.item_layout.*

class DrugInformationAdapter(var list: ArrayList<DrugInformation>) :
    RecyclerView.Adapter<DrugInformationAdapter.CustomList>() {

    inner class CustomList(view: View) : RecyclerView.ViewHolder(view) {

        var name = view.findViewById<MyTextViewMeriendaRegular>(R.id.text_name)
        var dose = view.findViewById<MyTextViewMeriendaRegular>(R.id.text_dose)
        var strength = view.findViewById<MyTextViewMeriendaRegular>(R.id.text_strength)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomList {
        return CustomList(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CustomList, position: Int) {
        var item = list.get(position)

        holder.name.text = "Name: ${item.name}"
        holder.dose.text = "Dose: ${item.dose}"
        holder.strength.text = "Strength: ${item.strength}"
    }


}