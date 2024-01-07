package com.example.photofrommars.data.dataSource

import com.example.photofrommars.data.dto.PhotoMarsRoversCuriosityDto
import com.example.photofrommars.entity.Photo

interface RoversCuriosityDataSource {

    suspend fun getList(page: Int): List<Photo>
}