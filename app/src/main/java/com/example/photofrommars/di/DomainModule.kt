package com.example.photofrommars.di

import com.example.cleancode.domain.repository.PhotoMarsRepository
import com.example.cleancode.domain.useCase.GetMarsPhotoCuriosityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideMarsPhotoCuriosityUseCase(repository: PhotoMarsRepository): GetMarsPhotoCuriosityUseCase {
        return GetMarsPhotoCuriosityUseCase(repository)
    }
}