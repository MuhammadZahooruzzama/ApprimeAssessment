package com.android.apprimeassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.android.apprimeassessment.ui.navigation.Navigation
import com.android.apprimeassessment.ui.theme.ApprimeAssessmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ApprimeAssessmentTheme {
                Navigation(
                    navController = navController,
                )
            }
        }
    }
}