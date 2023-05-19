package com.example.carmen.models

class Employer {

    var name:String= ""
    var id:String= ""
    var email:String= ""
    var  location:String= ""
    var password:String= ""
    var time_id:String= ""

    constructor(
        name: String,
        id: String,
        email: String,
        location: String,
        password: String,
        time_id: String
    ) {
        this.name = name
        this.id = id
        this.email = email
        this.location = location
        this.password = password
        this.time_id = time_id
    }
}