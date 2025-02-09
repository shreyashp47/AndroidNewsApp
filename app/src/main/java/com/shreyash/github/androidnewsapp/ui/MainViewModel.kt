package com.shreyash.github.androidnewsapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _count  = MutableLiveData(0)
    val count : LiveData<Int> = _count

    fun incrementCount(){
        _count.value = (_count.value ?: 0) + 1
    }

    fun resetCount(){
        _count.value = 0
    }

    fun decrementCount(){
        _count.value = (_count.value ?: 0) - 1
    }


}