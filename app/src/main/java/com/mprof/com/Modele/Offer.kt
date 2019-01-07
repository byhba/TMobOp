package com.mprof.com.Model

data class Offer (
    val id:Int,
    val prof:Int,
    val course_type:Int,
    val availability:String,
    val postedAt: String,
    val message:String,
    val isActive: String
)