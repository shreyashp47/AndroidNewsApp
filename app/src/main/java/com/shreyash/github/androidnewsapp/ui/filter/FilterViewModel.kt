package com.shreyash.github.androidnewsapp.ui.filter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shreyash.github.androidnewsapp.data.APIHelper
import com.shreyash.github.androidnewsapp.ui.base.UiState
import com.shreyash.github.androidnewsapp.utils.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class FilterViewModel(private val apiHelper: APIHelper,
                      private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Loading)

    val uiState: StateFlow<UiState<String>> = _uiState

    fun startFilterTask() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            val result = mutableListOf<Int>()
            (1..45).asFlow()
                .filter {
                    it % 2 == 0
                }.filter {
                    it % 3 == 0
                }
                .toList(result)
            _uiState.value = UiState.Success(result.toString())
        }
    }


}