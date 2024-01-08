package com.example.cleancode.data.dataSource

import com.example.cleancode.domain.entity.Photo

class PhotoMarsRoversCuriosityDataSourceImpl : RoversCuriosityDataSource {

    override suspend fun getList(page: Int): List<Photo> {
        val list = retrofit.getPhoto(page).photos
        return list
    }
}