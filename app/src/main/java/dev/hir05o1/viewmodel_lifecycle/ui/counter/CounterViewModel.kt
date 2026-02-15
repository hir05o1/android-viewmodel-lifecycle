package dev.hir05o1.viewmodel_lifecycle.ui.counter

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _uiState.asStateFlow()

    init {
        Log.i("Lifecycle-viewmodel", "CounterViewModel - init")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("Lifecycle-viewmodel", "CounterViewModel - onCleared")
    }


    fun increment() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count + 1)
    }

    fun decrement() {
        _uiState.value = _uiState.value.copy(count = _uiState.value.count - 1)
    }
}
