package com.shreyash.github.androidnewsapp.data

import retrofit2.http.GET

interface APIServices {

    @GET("users")
    suspend fun getUsers(): List<APIUsers>

    @GET("more-users")
    suspend fun getMoreUsers(): List<APIUsers>

    @GET("error")
    suspend fun getUsersWithError(): List<APIUsers>


}