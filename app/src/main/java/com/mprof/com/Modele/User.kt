package com.mprof.com.Model


data class User (
    val user_id: Int,
    val name: String,
    val fname: String,
    val email:String,
    val street_name: String,
    val street_nb: Int,
    val zip_code : Int,
    val city: String,
    val tel:Int,
    val pass:String,
    val role:String
    /*val discipline: String,
    val level: String,
    val birthdate: String,
    val registeredAt: String*/
)