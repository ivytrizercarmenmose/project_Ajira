package com.example.carmen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginEmpolyer : AppCompatActivity(){

       lateinit var edt_LOGIN:TextView
        lateinit var _email:EditText
        lateinit var _password:EditText
        lateinit var _btn_click:Button

        lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_empolyer)

        edt_LOGIN=findViewById(R.id.edt_login)
        _email= findViewById(R.id.edt_emailemployer)
        _password= findViewById(R.id.edt_P)
        _btn_click= findViewById(R.id.btn_C)

         _btn_click.setOnClickListener {


             //calling firebase
             auth = FirebaseAuth.getInstance()

             _btn_click.setOnClickListener {

                 var email = _email.text.toString().trim()
                 var password = _password.text.toString().trim()

                 if (email.isEmpty() || password.isEmpty()) {
                     Toast.makeText(this, "Cannot Login An Empty Field", Toast.LENGTH_SHORT)
                         .show()
                 } else {

                     auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                         if (it.isSuccessful) {


                             Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()



                             //navigate a user to a different page
                             var gotohome = Intent(this,View_employee::class.java)
                             startActivity(gotohome)
                             finish()


                         } else {

                             Toast.makeText(this, "Failed to Login Employer", Toast.LENGTH_SHORT)
                                 .show()
                             var errorlog = it.exception

                             val exceptionMessage = "$errorlog"
                             val delimiter = ":"
                             val index = exceptionMessage.indexOf(delimiter)
                             val trimmedMessage = if(index != -1) exceptionMessage.substring(index + delimiter.length).trim() else exceptionMessage

                             Toast.makeText(this, "Error is $trimmedMessage", Toast.LENGTH_SHORT).show()
                             Log.d("error_is_one", trimmedMessage)
                             Log.d("error_is_two", errorlog!!.message.toString())
                         }
                     }
                 }
             }
         }
    }
}