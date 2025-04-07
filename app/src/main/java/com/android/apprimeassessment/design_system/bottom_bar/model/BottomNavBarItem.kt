package com.android.apprimeassessment.design_system.bottom_bar.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavBarItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)
