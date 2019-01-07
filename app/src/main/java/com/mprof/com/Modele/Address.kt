package com.example.miharisoa.mobileproject.Model

data class Address(
    val adress_id: Int,
    val street_name: String,
    val street_nb: Int,
    val zip_code : Int,
    val city: String,
    val canton: String,
    val country: String
)