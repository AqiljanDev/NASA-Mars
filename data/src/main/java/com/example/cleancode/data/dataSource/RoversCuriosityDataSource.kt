package com.example.cleancode.data.dataSource

import com.example.cleancode.data.dto.PhotoMarsRoversCuriosityDto
import com.example.cleancode.domain.entity.Photo

interface RoversCuriosityDataSource {

    suspend fun getList(page: Int): List<com.example.cleancode.domain.entity.Photo>
}