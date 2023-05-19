package com.example.carmen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.carmen.models.Employee

class CustomAdapter(context: Context, data: ArrayList<Employee>) :
    ArrayAdapter<Employee>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                R.layout.list_item_employee,
                parent,
                false
            )
        }

        val currentEmployee = getItem(position)

        val textViewName = listItemView?.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = listItemView?.findViewById<TextView>(R.id.textViewEmail)
        val textViewPhone = listItemView?.findViewById<TextView>(R.id.textViewPhone)
        val textViewSpecialty = listItemView?.findViewById<TextView>(R.id.textViewSpecialty)
        val textViewLocation = listItemView?.findViewById<TextView>(R.id.textViewLocation)

        textViewName?.text = currentEmployee?.name
        textViewEmail?.text = currentEmployee?.email
        textViewPhone?.text = currentEmployee?.phone
        textViewSpecialty?.text = currentEmployee?.specialty
        textViewLocation?.text = currentEmployee?.location

        return listItemView!!
    }
}


