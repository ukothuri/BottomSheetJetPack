package com.intuit.bottomsheetjetpack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class BottomSheetState(var isVisible: Boolean = true) {
    fun show() {
        isVisible = true
    }
    fun hide() {
        isVisible = false }


}

@Composable
fun rememberBottomSheetState() = remember { BottomSheetState() }
