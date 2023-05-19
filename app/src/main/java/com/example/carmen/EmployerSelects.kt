package com.example.carmen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EmployerSelects : AppCompatActivity() {

    lateinit var select:TextView
    lateinit var laundry:Button
    lateinit var handy:Button
    lateinit var chauffuer:Button
    lateinit var movers:Button
    lateinit var baby:Button
    lateinit var male:Button
    lateinit var female:Button
    lateinit var call:Button
    lateinit var sms:Button
    lateinit var btnemail:Button
    lateinit var contact:TextView
    lateinit var specifyGender:TextView
    lateinit var edt_l:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_selects)

        select=findViewById(R.id.textView_select)
        contact=findViewById(R.id.textView_contact)
        specifyGender=findViewById(R.id.textView_gender)
        laundry=findViewById(R.id.checkBox)
        handy=findViewById(R.id.checkBox2)
        chauffuer=findViewById(R.id.checkBox4)
        movers=findViewById(R.id.checkBox3)
        baby=findViewById(R.id.checkBox7)
        male=findViewById(R.id.checkBox5)
        female=findViewById(R.id.checkBox6)
        call=findViewById(R.id.button)
        sms=findViewById(R.id.button2)
        btnemail=findViewById(R.id.button3)
        edt_l=findViewById(R.id.Edt_location)


        sms.setOnClickListener {

            val uri: Uri = Uri.parse("smsto:0716294504")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "hey,long time")
            startActivity(intent)}

        btnemail.setOnClickListener {


            var emailIntent = Intent(
                Intent.ACTION_SENDTO,
                Uri.fromParts("mailto", "carmenmose2004@gmail.com", "nul")
            )
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Application")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir,i'm applyng for the job posted")
            startActivity(Intent.createChooser(emailIntent, "Send Email"))}


    }

        }
