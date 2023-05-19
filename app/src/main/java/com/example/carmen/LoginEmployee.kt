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
import com.google.firebase.auth.ktx.oAuthCredential
import com.google.firebase.ktx.Firebase

class LoginEmployee : AppCompatActivity() {
    lateinit var login: TextView
    lateinit var email_: EditText
    lateinit var password_: EditText
    lateinit var btn_click: Button

    //initialize firebase
    lateinit var Auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_employee)

        login = findViewById(R.id.edt_login)
        email_ = findViewById(R.id.edt_e)
        password_ = findViewById(R.id.edt_p)
        btn_click = findViewById(R.id.btn_c)


        //calling firebase
        Auth = FirebaseAuth.getInstance()

        btn_click.setOnClickListener {

            var email = email_.text.toString().trim()
            var password = password_.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Cannot Login An Empty Field", Toast.LENGTH_SHORT).show()
            } else {

                Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()

                        //navigate a user to a different page
                        var gotohome = Intent(this, RegisterEmployee::class.java)
                        startActivity(gotohome)
                        finish()


                    }


                    else {
                        Toast.makeText(this, "Sorry failed to login", Toast.LENGTH_SHORT).show()


                    }
                }

            }
        }
    }
}
