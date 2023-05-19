package com.example.carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Register : AppCompatActivity() {

    lateinit var question:TextView
    lateinit var EmployerQ:Button
    lateinit var EmployeeQ:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        question=findViewById(R.id.Question_)
        EmployerQ=findViewById(R.id.employer_)
        EmployeeQ=findViewById(R.id.employee_)


        EmployerQ.setOnClickListener {
            var gotoreg_employer=Intent(this,RegisterEmployer::class.java)
            startActivity(gotoreg_employer)
        }
        EmployeeQ.setOnClickListener {

            var gotoreg_employee=Intent(this,RegisterEmployee::class.java)
            startActivity(gotoreg_employee)
        }
    }
}