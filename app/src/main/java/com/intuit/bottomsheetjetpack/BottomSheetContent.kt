package com.intuit.bottomsheetjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * Displays the content for a bottom sheet.
 */
@Composable
fun BottomSheetContent() {
    var textState by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        TopSection()
        BottomSection(textState, onTextChange = { textState = it })
    }
}

/**
 * Displays the top section of the bottom sheet with centered content and an end icon.
 */
@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
    ) {
        CenteredTitleAndIcon(Modifier.align(Alignment.Center))
        EndIcon(Modifier.align(Alignment.CenterEnd))
    }
}

/**
 * Displays a centered title and icon.
 */
@Composable
fun CenteredTitleAndIcon(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ai), // Replace with your drawable
            contentDescription = "AI Icon",
            modifier = Modifier.size(19.45.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Accuracy Check")
    }
}

/**
 * Displays an icon at the end (right side) of the top section.
 */
@Composable
fun EndIcon(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ai), // Replace with your drawable
        contentDescription = "Menu Icon",
        modifier = modifier.size(19.45.dp)
    )
}

/**
 * Displays the bottom section of the bottom sheet.
 *
 * @param text The current text.
 * @param onTextChange Function to handle text changes.
 */
@Composable
fun BottomSection(text: String, onTextChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(328.dp)
            .background(Color(0xFF00796B)) // Teal 700 color
            .padding(10.dp)
    ) {
        BottomContent(text, onTextChange)
    }
}

/**
 * Displays the content of the bottom section.
 */
@Composable
fun BottomContent(text: String, onTextChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Text("1098 MORTGAGE INTEREST", modifier = Modifier.padding(bottom = 8.dp))
        Text("Who received your mortgage payments? It could be a bank, credit union, or other lender.")
        Text("Enter recipient/lendor name", modifier = Modifier.padding(top = 8.dp))

        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        ActionButtons()
    }
}

/**
 * Displays action buttons.
 */
@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Button(onClick = { /* Skip action */ }) {
            Text("Skip")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* Update action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text("Update", color = Color.White)
        }
    }
}
