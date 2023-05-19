package com.example.carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class AllUsersActivity : AppCompatActivity() {

    lateinit var name:EditText
    lateinit var phone:EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var create:Button
    lateinit var login:Button
    lateinit var AJIRA:TextView
    lateinit var comment:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_users)

        AJIRA=findViewById(R.id.textView)
        comment=findViewById(R.id.comment)
        name=findViewById(R.id.edtname)
        phone=findViewById(R.id.edtphone)
        email=findViewById(R.id.edtemail)
        password=findViewById(R.id.edtpassword)
        create=findViewById(R.id.btncreate)
        login=findViewById(R.id.btnlogin)


        create.setOnClickListener {
            var gotomain=Intent(this,MainActivity::class.java)
            startActivity(gotomain)

        }
        login.setOnClickListener {
            var gotoMAIN=Intent(this,MainActivity::class.java)
            startActivity(gotoMAIN)
        }
    }
}