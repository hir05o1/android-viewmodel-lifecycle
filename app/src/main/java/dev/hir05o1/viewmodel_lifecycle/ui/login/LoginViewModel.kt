package dev.hir05o1.viewmodel_lifecycle.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    init {
        Log.i("Lifecycle-ViewModel", "LoginViewModel - init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("Lifecycle-ViewModel", "LoginViewModel - onCleared")
    }

    fun completeLogin() {
        _uiState.value = LoginUiState(isLoggedIn = true)
    }
}
