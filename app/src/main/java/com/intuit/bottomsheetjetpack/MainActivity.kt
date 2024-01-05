package com.intuit.bottomsheetjetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

/**
 * MainActivity is the entry point of the application.
 * It sets up the main content view with the MainScreen composable function.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

/**
 * MainScreen is the primary composable function for the application.
 * It sets up a ModalBottomSheetLayout and a button to toggle the bottom sheet's visibility.
 * It also includes a LaunchedEffect to show a toast message when the bottom sheet is dismissed.
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    // Context used for showing toast messages
    val context = LocalContext.current
    // State for the modal bottom sheet
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    // Coroutine scope for launching side effects
    val coroutineScope = rememberCoroutineScope()

    // Observe changes in the bottom sheet's visibility to show a toast when it's dismissed
    LaunchedEffect(sheetState.currentValue) {
        if (sheetState.currentValue == ModalBottomSheetValue.Hidden) {
            Toast.makeText(context, "Bottom Sheet Dismissed", Toast.LENGTH_SHORT).show()
        }
    }

    // Layout definition for the screen
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            BottomSheetContent()
            Spacer(modifier = Modifier.height(300.dp))
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Button to toggle the visibility of the bottom sheet
            Button(onClick = {
                coroutineScope.launch {
                    if (sheetState.isVisible) {
                        sheetState.hide()
                    } else {
                        sheetState.show()
                    }
                }
            }) {
                Text("Toggle Bottom Sheet")
            }
        }
    }
}
