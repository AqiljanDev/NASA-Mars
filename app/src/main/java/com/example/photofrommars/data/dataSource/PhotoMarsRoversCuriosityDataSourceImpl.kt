package com.example.photofrommars.data.dataSource

import android.util.Log
import com.example.photofrommars.data.dto.PhotoMarsRoversCuriosityDto
import com.example.photofrommars.entity.Photo

class PhotoMarsRoversCuriosityDataSourceImpl : RoversCuriosityDataSource {

    override suspend fun getList(page: Int): List<Photo> {
        val list = retrofit.getPhoto(page).photos
        Log.d("Mylog", "Data source = ${list[0].img_src}")
        return list
    }
}