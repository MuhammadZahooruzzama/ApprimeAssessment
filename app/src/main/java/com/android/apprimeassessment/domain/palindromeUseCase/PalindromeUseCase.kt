package com.android.apprimeassessment.domain.palindromeUseCase

import com.android.apprimeassessment.data.repository.PalindromeRepository
import javax.inject.Inject

class PalindromeUseCase @Inject constructor(private val palindromeRepository: PalindromeRepository) {

    suspend fun checkPalindromeResult(value: String): Boolean {
        return palindromeRepository.checkPalindrome(value)
    }

    suspend fun savePalindrome(value: String) {
        palindromeRepository.savePalindrome(value)
    }

    suspend fun loadSavedPalindrome(): List<String> {
        return palindromeRepository.getSavedPalindromes()
    }
}