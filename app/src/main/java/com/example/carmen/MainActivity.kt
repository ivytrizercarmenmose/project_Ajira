package com.example.carmen

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    lateinit var create: Button
    lateinit var login: Button
    lateinit var AJIRA: TextView
    lateinit var Comment: TextView
    lateinit var Editname: EditText
    lateinit var Editemail: EditText
    lateinit var Editphone: EditText
    lateinit var Editpassword: EditText

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AJIRA = findViewById(R.id.textView)
        create = findViewById(R.id.btncreate)
        login = findViewById(R.id.btnlogin)
        Comment = findViewById(R.id.comment)
        Editname = findViewById(R.id.Editname)
        Editemail = findViewById(R.id.Editemail)
        Editphone = findViewById(R.id.Editphone)
        Editpassword = findViewById(R.id.Editpass)

        firebaseAuth = FirebaseAuth.getInstance()

        login.setOnClickListener {
            val goToLogin = Intent(this, Login::class.java)
            startActivity(goToLogin)
        }

        create.setOnClickListener {
            val name = Editname.text.toString().trim()
            val email = Editemail.text.toString().trim()
            val phone = Editphone.text.toString().trim()
            val password = Editpassword.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Cannot Submit Empty Field", Toast.LENGTH_SHORT).show()
            } else {
                createNewUser(email, password)
                val goToLogin = Intent(this, Login::class.java)
                startActivity(goToLogin)
            }
        }
    }

    private fun createNewUser(email: String, password: String) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Creating Account")
        progressDialog.setMessage("Please Wait...")
        progressDialog.show()

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                progressDialog.dismiss()
                if (task.isSuccessful) {
                    val currentUser: FirebaseUser? = firebaseAuth.currentUser
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()
                    // Continue with any additional steps after successful registration, such as saving user data.

                } else {
                    val exception = task.exception
                    Toast.makeText(this, "Failed to Create Account: ${exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}


