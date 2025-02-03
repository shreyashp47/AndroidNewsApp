package com.shreyash.github.androidnewsapp.data

import kotlinx.coroutines.flow.Flow


interface APIHelper {

    fun getUsers(): Flow<List<APIUsers>>

    fun getMoreUsers(): Flow<List<APIUsers>>

    fun getUsersWithError(): Flow<List<APIUsers>>

}