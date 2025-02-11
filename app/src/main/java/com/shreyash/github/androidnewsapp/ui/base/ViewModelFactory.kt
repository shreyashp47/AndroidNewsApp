package com.shreyash.github.androidnewsapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shreyash.github.androidnewsapp.data.APIHelper
import com.shreyash.github.androidnewsapp.ui.filter.FilterViewModel
import com.shreyash.github.androidnewsapp.ui.userlist.UserListViewModel
import com.shreyash.github.androidnewsapp.utils.DispatcherProvider

class ViewModelFactory(
    private val apiHelper: APIHelper,
    private val dispatcherProvider: DispatcherProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            return UserListViewModel(apiHelper, dispatcherProvider) as T
        }
        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            return FilterViewModel(apiHelper, dispatcherProvider) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}