package com.android.apprimeassessment.ui.palindrome_results.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.apprimeassessment.R
import com.android.apprimeassessment.ui.palindrome_results.models.SavedPalindromeUIState

@Composable
fun PalindromeResultsScreen(state: SavedPalindromeUIState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(stringResource(R.string.saved_palindromes))

        LazyColumn {
            items(state.list) {
                Text(it, modifier = Modifier.padding(8.dp))
            }
        }
    }
}