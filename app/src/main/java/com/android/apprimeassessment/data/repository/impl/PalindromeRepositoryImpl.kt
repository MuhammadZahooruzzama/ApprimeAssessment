package com.android.apprimeassessment.data.repository.impl

import android.content.SharedPreferences
import com.android.apprimeassessment.data.repository.PalindromeRepository
import javax.inject.Inject
import androidx.core.content.edit

const val PALINDROME_KEY = "palindrome_key"

class PalindromeRepositoryImpl @Inject constructor(private val sharedPreferences: SharedPreferences) : PalindromeRepository {

    override suspend fun checkPalindrome(value: String): Boolean {
        return value == value.reversed()
    }

    override suspend fun getSavedPalindromes(): List<String> {
        return sharedPreferences.getStringSet(PALINDROME_KEY, emptySet())?.toList() ?: emptyList()
    }

    override suspend fun savePalindrome(value: String) {
        val savedPalindromes = getSavedPalindromes().toMutableList()
        savedPalindromes.add(value)
        sharedPreferences.edit {
            putStringSet(PALINDROME_KEY, savedPalindromes.toSet())
        }
    }
}