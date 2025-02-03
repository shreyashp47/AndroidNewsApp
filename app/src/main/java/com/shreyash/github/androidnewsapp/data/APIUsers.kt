package com.shreyash.github.androidnewsapp.data

import com.google.gson.annotations.SerializedName

data class APIUsers (
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("email")
    val email : String,
    @SerializedName("avatar")
    val avtar : String
)