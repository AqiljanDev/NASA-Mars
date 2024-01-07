package com.example.photofrommars.data.repository

import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.photofrommars.data.dataSource.PhotoMarsRoversCuriosityDataSourceImpl
import com.example.photofrommars.data.dataSource.RoversCuriosityDataSource
import com.example.photofrommars.data.pagingSource.PhotoMarsRoversCuriosityPagingSource
import com.example.photofrommars.domain.repository.PhotoMarsRepository
import com.example.photofrommars.entity.Photo
import com.example.photofrommars.entity.PhotoMarsRoversCuriosity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotoMarsRepositoryImpl @Inject constructor(
    private val photoMarsRoversCuriosityPagingSource: PhotoMarsRoversCuriosityPagingSource
    ) : PhotoMarsRepository {
    override suspend fun getListPhoto(): Flow<PagingData<Photo>> {
        Log.d("Mylog", "repository")
        delay(2000)
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { PhotoMarsRoversCuriosityPagingSource(
                PhotoMarsRoversCuriosityDataSourceImpl()
            ) }
        ).flow
    }

}