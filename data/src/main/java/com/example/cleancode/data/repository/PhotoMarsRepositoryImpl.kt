package com.example.cleancode.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.cleancode.data.pagingSource.PhotoMarsRoversCuriosityPagingSource
import com.example.cleancode.domain.entity.Photo
import javax.inject.Inject

class PhotoMarsRepositoryImpl @Inject constructor(
    private val photoMarsRoversCuriosityPagingSource: PhotoMarsRoversCuriosityPagingSource
    ) : com.example.cleancode.domain.repository.PhotoMarsRepository {
    override suspend fun getListPhoto(): Pager<Int, Photo> = Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { photoMarsRoversCuriosityPagingSource }
        )


}