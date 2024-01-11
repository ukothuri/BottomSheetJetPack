package com.intuit.bottomsheetjetpack

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * A composable function that manages the display of the bottom sheet.
 * Uses a controller to manage its visibility state.
 *
 * @param bottomSheetController The controller that manages the visibility of the bottom sheet.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetHandler(bottomSheetController: BottomSheetController) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    // Link the bottom sheet's visibility control to the controller
    bottomSheetController.setShowBottomSheet {
        coroutineScope.launch {
            if (sheetState.isVisible) sheetState.hide() else sheetState.show()
        }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            BottomSheetContent() // Define your bottom sheet content here
            Spacer(modifier = Modifier.height(300.dp))
        }
    ) {
        // Main content of your screen, if any
    }
}
