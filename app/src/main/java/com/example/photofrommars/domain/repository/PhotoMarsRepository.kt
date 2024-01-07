package com.example.photofrommars.domain.repository

import androidx.paging.PagingData
import com.example.photofrommars.entity.Photo
import com.example.photofrommars.entity.PhotoMarsRoversCuriosity
import kotlinx.coroutines.flow.Flow

interface PhotoMarsRepository {

    suspend fun getListPhoto(): Flow<PagingData<Photo>>
}