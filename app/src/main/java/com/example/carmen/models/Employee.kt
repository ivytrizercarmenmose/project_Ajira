package com.example.carmen.models

import android.provider.ContactsContract.CommonDataKinds.Email

class Employee {

    var name:String = ""
    var specialty:String = ""
    var email:String = ""
    var gender:String = ""
    var location:String = ""
    var phone:String = ""
    var password:String = ""
    var idNumber:String = ""
    var id:String = ""

    constructor(
        name: String,
        specialty: String,
        email: String,
        gender: String,
        location: String,
        phone: String,
        password: String,
        idNumber: String,
        id: String
    ) {
        this.name = name
        this.specialty = specialty
        this.email = email
        this.gender = gender
        this.location = location
        this.phone = phone
        this.password = password
        this.idNumber = idNumber
        this.id = id
    }
    constructor()
}