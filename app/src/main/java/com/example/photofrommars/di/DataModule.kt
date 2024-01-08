package com.example.photofrommars.di

import androidx.paging.PagingSource
import com.example.cleancode.data.dataSource.PhotoMarsRoversCuriosityDataSourceImpl
import com.example.cleancode.data.dataSource.RoversCuriosityDataSource
import com.example.cleancode.data.pagingSource.PhotoMarsRoversCuriosityPagingSource
import com.example.cleancode.data.repository.PhotoMarsRepositoryImpl
import com.example.cleancode.domain.repository.PhotoMarsRepository
import com.example.cleancode.domain.entity.Photo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideRoversCuriosityDataSource(): RoversCuriosityDataSource {
        return PhotoMarsRoversCuriosityDataSourceImpl()
    }

    @Provides
    fun providePhotoMarsRepository(pagingSource: PhotoMarsRoversCuriosityPagingSource): PhotoMarsRepository {
        return PhotoMarsRepositoryImpl(pagingSource)
    }

    @Provides
    fun providePhotoMarsRoversCuriosityPagingSource(dataSource: RoversCuriosityDataSource): PagingSource<Int, Photo> {
        return PhotoMarsRoversCuriosityPagingSource(
            dataSource
        )
    }
}