package com.android.apprimeassessment.di

import com.android.apprimeassessment.data.repository.PalindromeRepository
import com.android.apprimeassessment.data.repository.impl.PalindromeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryBindingModule {

    @Binds
    fun bindPalindromeRepositoryImpl(repository: PalindromeRepositoryImpl): PalindromeRepository
}

