package com.example.carmen

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Identity
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.carmen.models.Employee
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import java.net.IDN
import javax.xml.namespace.NamespaceContext

class RegisterEmployee : AppCompatActivity() {

    lateinit var Names: EditText
    lateinit var Specialty: EditText
    lateinit var ID:EditText
    lateinit var Email:EditText
    lateinit var Gender:EditText
    lateinit var Phone:EditText
    lateinit var Location:EditText
    lateinit var Password:EditText
    lateinit var Submit:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_employee)

        Names=findViewById(R.id.edt_Name)
        ID=findViewById(R.id.edt_Number)
        Email=findViewById(R.id.edt_Email)
        Gender=findViewById(R.id.edt_Gender)
        Phone=findViewById(R.id.edt_Phone)
        Location=findViewById(R.id.edt_Location)
        Password=findViewById(R.id.edt_Password)
        Submit=findViewById(R.id.btn_Submit)
        Specialty=findViewById(R.id.Specialty)

        var database=FirebaseDatabase.getInstance()
        var databaseref=database.reference

        Submit.setOnClickListener {

        var Names_=Names.text.toString().trim()
        var ID_=ID.text.toString().trim()
        var Email_=Email.text.toString().trim()
        var Gender_=Gender.text.toString().trim()
        var Phone_=Phone.text.toString().trim()
        var Location_=Location.text.toString().trim()
        var Password_=Password.text.toString().trim()
        var Specialty_=Specialty.text.toString().trim()

            //add a unique ID
       var time_id = System.currentTimeMillis().toString()


            //add progress dialog
            var progress = ProgressDialog(this)
            progress.setTitle("Saving Employee Record")
            progress.setMessage("Please Wait........")


        if (Names_.isEmpty()||ID_.isEmpty()||Email_.isEmpty()||Gender_.isEmpty()||Phone_.isEmpty()||Location_.isEmpty()||Password_.isEmpty()||Specialty_.isEmpty()){
            Toast.makeText(this, "Cannot Submit Empty Field", Toast.LENGTH_SHORT).show()
        }else{



            //proceed to upload Data
            var child_employee = FirebaseDatabase.getInstance().reference.child("Employees/"+ time_id)

            //take data from our model
            var employee_data = Employee(Names_, Email_,Gender_,Location_,Phone_,Password_,ID_,Specialty_,time_id)


            progress.show()

            child_employee.setValue(employee_data).addOnCompleteListener {

                progress.dismiss()


                if (it.isSuccessful) {

                    Toast.makeText(this, "Employee Record Registered Successfully", Toast.LENGTH_SHORT).show()

                   var gotopage=Intent(this,Employeepage::class.java)
                   startActivity(gotopage)


                } else {


                    Toast.makeText(this, "Failed to register Please Try Again", Toast.LENGTH_SHORT).show()



                }



            }









        }



        }

    }
}