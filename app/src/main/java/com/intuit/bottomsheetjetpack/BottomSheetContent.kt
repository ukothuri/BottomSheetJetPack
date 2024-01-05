package com.intuit.bottomsheetjetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * Displays a bottom sheet with a top section containing a title and icon, and a bottom section
 * with a text field and action buttons.
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
 * Represents the top section of the bottom sheet, featuring centered title and icon.
 */
@Composable
fun TopSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_SECTION_HEIGHT)
            .background(PRIMARY_WHITE)
    ) {
        CenteredTitleAndIcon(Modifier.align(Alignment.Center))
        EndIcon(Modifier.align(Alignment.CenterEnd))
    }
}

/**
 * Displays the centered title and icon in the top section.
 */
@Composable
fun CenteredTitleAndIcon(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ai), // Replace with your drawable
            contentDescription = AppStrings.ACCURACY_CHECK,
            modifier = Modifier.size(ICON_SIZE)
        )
        Spacer(modifier = Modifier.width(ACTION_BUTTON_SPACING))
        Text(AppStrings.ACCURACY_CHECK)
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
        modifier = modifier.size(ICON_SIZE)
    )
}

/**
 * Represents the bottom section of the bottom sheet, containing a text field and action buttons.
 */
@Composable
fun BottomSection(text: String, onTextChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(BOTTOM_SECTION_HEIGHT)
            .background(TEAL_700)
            .padding(10.dp)
    ) {
        BottomContent(text, onTextChange)
    }
}

/**
 * Displays the content inside the bottom section, including a TextField for user input and action buttons.
 */
@Composable
fun BottomContent(text: String, onTextChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PRIMARY_WHITE)
            .padding(10.dp)
    ) {
        Text(AppStrings.MORTGAGE_INTEREST, modifier = Modifier.padding(bottom = 8.dp))
        Text(AppStrings.MORTGAGE_DETAIL)
        Text(AppStrings.RECIPIENT_NAME, modifier = Modifier.padding(top = 8.dp))

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
 * Displays action buttons for the bottom sheet.
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
            Text(AppStrings.SKIP)
        }
        Spacer(modifier = Modifier.width(ACTION_BUTTON_SPACING))
        Button(
            onClick = { /* Update action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = PRIMARY_BLUE)
        ) {
            Text(AppStrings.UPDATE, color = PRIMARY_WHITE)
        }
    }
}
