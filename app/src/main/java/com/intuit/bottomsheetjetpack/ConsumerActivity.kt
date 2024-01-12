package com.intuit.bottomsheetjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * The main activity for the application. It sets up the UI for the main screen.
 */
class ConsumerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

/**
 * The main screen composable function.
 * It displays a button that triggers the display of a bottom sheet.
 */
@Composable
fun MainScreen() {
    // Controller for managing the bottom sheet
    val bottomSheetController = remember { BottomSheetController() }

    // Button that triggers the bottom sheet
    Button(
        onClick = { bottomSheetController.show() },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Open Bottom Sheet")
    }

    // Bottom sheet handler composable
    BottomSheetHandler(bottomSheetController)
}
