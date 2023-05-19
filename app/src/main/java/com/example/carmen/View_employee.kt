package com.example.carmen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.carmen.models.Employee
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class View_employee : AppCompatActivity() {

    lateinit var my_list_view: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_employee2)

        my_list_view = findViewById(R.id.mylistview)
        val user: ArrayList<Employee> = ArrayList()
        val myadapter = CustomAdapter(this, user)
        val my_db = FirebaseDatabase.getInstance().reference.child("Employees")

        my_db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                user.clear()
                for (snap in snapshot.children) {
                    val person = snap.getValue(Employee::class.java)
                    person?.let { user.add(it) }
                }

                myadapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "Failed to Display Data", Toast.LENGTH_SHORT).show()
            }
        })

        my_list_view.adapter = myadapter
    }
}



