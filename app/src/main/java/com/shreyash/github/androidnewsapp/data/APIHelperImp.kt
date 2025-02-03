package com.shreyash.github.androidnewsapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class APIHelperImp(private val apiServices: APIServices) : APIHelper {

    override fun getUsers(): Flow<List<APIUsers>> = flow { emit(apiServices.getUsers()) }

    override fun getMoreUsers(): Flow<List<APIUsers>> = flow { emit(apiServices.getMoreUsers()) }

    override fun getUsersWithError(): Flow<List<APIUsers>> =
        flow { emit(apiServices.getUsersWithError()) }


}