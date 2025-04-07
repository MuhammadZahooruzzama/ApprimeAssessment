package com.android.apprimeassessment.ui.palindrome.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.apprimeassessment.domain.palindromeUseCase.PalindromeUseCase
import com.android.apprimeassessment.ui.palindrome.models.PalindromeInputUIEvent
import com.android.apprimeassessment.ui.palindrome.models.PalindromeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PalindromeViewmodel @Inject constructor(
    private val palindromeUseCase: PalindromeUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PalindromeUIState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(event: PalindromeInputUIEvent) {
        when (event) {
            is PalindromeInputUIEvent.OnPalindromeValueChanged -> _uiState.update {
                it.copy(palindromeValue = event.value)
            }

            PalindromeInputUIEvent.OnPalindromeCheckButtonClick -> checkPalindromeResult()
        }
    }

    private fun checkPalindromeResult() {
        viewModelScope.launch(Dispatchers.IO) {
            val palindromeValue = _uiState.value.palindromeValue
            if (palindromeUseCase.checkPalindromeResult(palindromeValue)) {
                palindromeUseCase.savePalindrome(palindromeValue)
                _uiState.update {
                    it.copy(
                        palindromeResult = "$palindromeValue is a Palindrome"
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        palindromeResult = "$palindromeValue is not a Palindrome"
                    )
                }
            }
        }
    }
}