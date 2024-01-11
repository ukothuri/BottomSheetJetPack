package com.intuit.bottomsheetjetpack

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.material.ExperimentalMaterialApi

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetManager(content: @Composable (showBottomSheet: (Boolean) -> Unit) -> Unit) {
    var showSheet by remember { mutableStateOf(false) }

    content { shouldShow ->
        showSheet = shouldShow
    }

    if (showSheet) {
        ShowBottomSheet(onDismiss = { showSheet = false })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowBottomSheet(onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    // Trigger sheet visibility change
    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue != ModalBottomSheetValue.Expanded) {
            sheetState.show()
        }
    }

    if (sheetState.currentValue == ModalBottomSheetValue.Hidden) {
        onDismiss()
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = { BottomSheetContent(onDismiss) }
    ) {
        // Main content, if any, goes here
    }
}

@Composable
fun BottomSheetContent(onDismiss: () -> Unit) {
    // Define the UI for your bottom sheet here
    // ...
}
