package com.android.apprimeassessment.ui.palindrome_results.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.apprimeassessment.domain.palindromeUseCase.PalindromeUseCase
import com.android.apprimeassessment.ui.palindrome_results.models.SavedPalindromeUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedPalindromeViewmodel @Inject constructor(
    private val palindromeUseCase: PalindromeUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(SavedPalindromeUIState(emptyList()))
    val uiState = _uiState.asStateFlow()

    init {
        getPalindromes()
    }

    private fun getPalindromes(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(list = palindromeUseCase.loadSavedPalindrome())
            }
        }
    }
}