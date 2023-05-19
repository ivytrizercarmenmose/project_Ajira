package com.example.carmen

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.carmen.models.Employer
import com.google.firebase.database.FirebaseDatabase

class RegisterEmployer : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var id:EditText
    lateinit var email:EditText
    lateinit var location:EditText
    lateinit var password:EditText
    lateinit var submit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_employer)

        name = findViewById(R.id.edt_name)
        id = findViewById(R.id.edt_number)
        location = findViewById(R.id.edt_location)
        password = findViewById(R.id.edt_password)
        submit = findViewById(R.id.btn_submit)
        email = findViewById(R.id.edt_Email_)

        var db = FirebaseDatabase.getInstance()
        var dbref = db.reference


        submit.setOnClickListener {

            var name_ = name.text.toString().trim()
            var id_ = id.text.toString().trim()
            var location_ = location.text.toString().trim()
            var password_ = password.text.toString().trim()
            var email_ = email.text.toString().trim()


            var time_id = System.currentTimeMillis().toString()


            var progress_ = ProgressDialog(this)
            progress_.setTitle("Savimg Employer Records")
            progress_.setMessage("Please Wait....")


            if (name_.isEmpty() || id_.isEmpty() || location_.isEmpty() || password_.isEmpty() || email_.isEmpty()) {
                Toast.makeText(this, "Cannot Submit An Empty Field", Toast.LENGTH_SHORT).show()
            }else{

                //upload data
                var child_employer = FirebaseDatabase.getInstance().reference.child("Employers/"+ time_id)

                //take data from model

                var employer_data = Employer(name_,id_,email_,location_,password_,time_id)

                progress_.show()

                child_employer.setValue(employer_data).addOnCompleteListener {

                    progress_.dismiss()


                    if (it.isSuccessful){
                        Toast.makeText(this, "Employer Records Registered Succussfully", Toast.LENGTH_SHORT).show()

                        var intent = Intent(this, LoginEmpolyer::class.java)
                        startActivity(intent)

                    }else{

                        Toast.makeText(this, "Failed to Register ...Please Try Again", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }
}