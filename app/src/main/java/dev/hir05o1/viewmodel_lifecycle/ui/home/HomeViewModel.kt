package dev.hir05o1.viewmodel_lifecycle.ui.home

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun updateBgColor() {
        _uiState.update { currentState ->
            currentState.copy(
                bgColor = if (currentState.bgColor == Color.White) Color.Black else Color.White
            )
        }
    }
}
