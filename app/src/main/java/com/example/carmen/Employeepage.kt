package com.example.carmen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Employeepage : AppCompatActivity() {

   lateinit var employeepage:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employeepage)

        employeepage=findViewById(R.id.epage)


    }
}