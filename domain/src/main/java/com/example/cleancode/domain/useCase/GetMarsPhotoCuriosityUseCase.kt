package com.example.cleancode.domain.useCase

import com.example.cleancode.domain.repository.PhotoMarsRepository

class GetMarsPhotoCuriosityUseCase (
    private val repository: PhotoMarsRepository
) {

    suspend fun execute() = repository.getListPhoto()
}