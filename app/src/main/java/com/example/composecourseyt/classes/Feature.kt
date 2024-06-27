package com.example.composecourseyt.classes

import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)

data class IconName(var image: Int, var name: String)