package com.intuit.genux

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

// ViewModel to manage the bottom sheet's visibility
class SharedViewModel : ViewModel() {
    val showBottomSheet = mutableStateOf(false)

    fun toggleBottomSheet(show: Boolean) {
        showBottomSheet.value = show
    }
}
