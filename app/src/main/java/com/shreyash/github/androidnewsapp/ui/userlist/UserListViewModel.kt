package com.shreyash.github.androidnewsapp.ui.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shreyash.github.androidnewsapp.data.APIHelper
import com.shreyash.github.androidnewsapp.data.APIUsers
import com.shreyash.github.androidnewsapp.ui.base.UiState
import com.shreyash.github.androidnewsapp.utils.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserListViewModel(private val apiHelper: APIHelper,
    private val dispatcherProvider: DispatcherProvider) : ViewModel() {
        private val _uiState = MutableStateFlow<UiState<List<APIUsers>>>(UiState.Loading)
        val uiState : StateFlow<UiState<List<APIUsers>>> = _uiState

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(dispatcherProvider.main) {
            _uiState.value = UiState.Loading
            apiHelper.getUsers()
                .flowOn(dispatcherProvider.io)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}