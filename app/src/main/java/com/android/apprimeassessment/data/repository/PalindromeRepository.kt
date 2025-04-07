package com.android.apprimeassessment.data.repository

interface PalindromeRepository {
    suspend fun checkPalindrome(value: String): Boolean
    suspend fun getSavedPalindromes(): List<String>
    suspend fun savePalindrome(value: String)
}