package com.example.photofrommars.domain.useCase


import androidx.paging.PagingData
import com.example.photofrommars.domain.repository.PhotoMarsRepository
import com.example.photofrommars.entity.Photo
import com.example.photofrommars.entity.PhotoMarsRoversCuriosity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMarsPhotoCuriosityUseCase @Inject constructor(
    private val repository: PhotoMarsRepository
) {

    suspend fun execute(): Flow<PagingData<Photo>> {
        return repository.getListPhoto()
    }
}