package com.android.apprimeassessment.ui.palindrome.models

sealed interface PalindromeInputUIEvent {
    data class OnPalindromeValueChanged(val value : String) : PalindromeInputUIEvent
    data object OnPalindromeCheckButtonClick : PalindromeInputUIEvent
}