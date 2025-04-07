package com.android.apprimeassessment.ui.palindrome.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.android.apprimeassessment.R
import com.android.apprimeassessment.ui.palindrome.models.PalindromeInputUIEvent
import com.android.apprimeassessment.ui.palindrome.models.PalindromeUIState

@Composable
fun PalindromeScreen(onEvent: (PalindromeInputUIEvent) -> Unit, state: PalindromeUIState) {
    PalindromeScreenBody(onEvent, state)
}

@Composable
fun PalindromeScreenBody(onEvent: (PalindromeInputUIEvent) -> Unit, state: PalindromeUIState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = state.palindromeValue,
            onValueChange = { value ->
                onEvent(PalindromeInputUIEvent.OnPalindromeValueChanged(value))
            },
            label = { Text(stringResource(state.palindromeLabel)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onEvent(PalindromeInputUIEvent.OnPalindromeCheckButtonClick)
        }) {
            Text(text = stringResource(R.string.palindrome_button_placeholder))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(state.palindromeResult)
    }
}
