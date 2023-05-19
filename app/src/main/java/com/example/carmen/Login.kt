package com.example.carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Login : AppCompatActivity() {
    lateinit var question: TextView
    lateinit var Employer__: Button
    lateinit var Employee__: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        question=findViewById(R.id.LoGiN)
        Employer__=findViewById(R.id.EMPLOYER)
        Employee__=findViewById(R.id.EMPLOYEE)


        Employer__.setOnClickListener {
           var gotolog_employer=Intent(this,LoginEmpolyer::class.java)
            startActivity(gotolog_employer)
        }
        Employee__.setOnClickListener {
            var gotolog_employee=Intent(this,LoginEmployee::class.java)
            startActivity(gotolog_employee)
        }
    }
}