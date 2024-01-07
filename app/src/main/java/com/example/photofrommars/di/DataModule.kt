package com.example.photofrommars.di

import androidx.paging.PagingSource
import com.example.photofrommars.data.dataSource.PhotoMarsRoversCuriosityDataSourceImpl
import com.example.photofrommars.data.dataSource.RoversCuriosityDataSource
import com.example.photofrommars.data.pagingSource.PhotoMarsRoversCuriosityPagingSource
import com.example.photofrommars.data.repository.PhotoMarsRepositoryImpl
import com.example.photofrommars.domain.repository.PhotoMarsRepository
import com.example.photofrommars.entity.Photo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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
        return PhotoMarsRoversCuriosityPagingSource(dataSource)
    }
}