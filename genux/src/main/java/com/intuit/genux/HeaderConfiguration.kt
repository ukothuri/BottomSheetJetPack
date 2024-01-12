package com.intuit.genux

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily

// The HeaderConfiguration data class and related types
data class HeaderConfiguration(
    val title: String = "Intuit AI",
    val font: FontFamily = FontFamily.Default,
    val color: Color = Color.Black,
    val isBetaExperience: Boolean = true,
    val headerTitleLogoAlignment: HeaderLogoTitleAlignment = HeaderLogoTitleAlignment.LEADING,
    val option: HeaderOptionConfiguration = HeaderOptionConfiguration()
) {
    enum class HeaderLogoTitleAlignment {
        LEADING, CENTER
    }

    data class HeaderOptionConfiguration(
        val isMenu: Boolean = true,
        val optionIcon: IDSIconEnum = IDSIconEnum.OVERFLOW_WEB
    )
}

enum class IDSIconEnum {
    OVERFLOW_WEB, CLOSE
    // add other cases as needed
}
