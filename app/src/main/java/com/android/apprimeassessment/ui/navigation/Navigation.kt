package com.android.apprimeassessment.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import com.android.apprimeassessment.design_system.bottom_bar.BottomNaviBar
import com.android.apprimeassessment.ui.palindrome.view.PalindromeScreen
import com.android.apprimeassessment.ui.palindrome.viewmodel.PalindromeViewmodel
import com.android.apprimeassessment.ui.palindrome_results.view.PalindromeResultsScreen
import com.android.apprimeassessment.ui.palindrome_results.viewmodel.SavedPalindromeViewmodel

@Composable
fun Navigation(navController: NavHostController) {
    Scaffold(bottomBar = { BottomNaviBar(navController) }) { innerPadding ->
        val graph =
            navController.createGraph(startDestination = Routes.HOME) {
                composable(route = Routes.HOME) {
                    val viewModel = hiltViewModel<PalindromeViewmodel>()
                    val state by viewModel.uiState.collectAsStateWithLifecycle()
                    PalindromeScreen( onEvent = viewModel::onEvent,state)
                }
                composable(route = Routes.LIST) {
                    val viewModel = hiltViewModel<SavedPalindromeViewmodel>()
                    val state by viewModel.uiState.collectAsStateWithLifecycle()
                    PalindromeResultsScreen(state)
                }

            }
        NavHost(
            navController = navController,
            graph = graph,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

