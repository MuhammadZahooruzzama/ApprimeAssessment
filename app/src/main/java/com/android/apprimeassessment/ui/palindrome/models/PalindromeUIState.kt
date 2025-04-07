package com.android.apprimeassessment.ui.palindrome.models

import androidx.annotation.StringRes
import com.android.apprimeassessment.R

data class PalindromeUIState(
    val palindromeValue: String = "",
    val palindromeResult: String = "",
    @StringRes val palindromeLabel: Int = R.string.palindrome_placeholder
)