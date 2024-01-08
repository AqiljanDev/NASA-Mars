package com.example.cleancode.domain.repository

import androidx.paging.Pager
import com.example.cleancode.domain.entity.Photo

interface PhotoMarsRepository {

    suspend fun getListPhoto(): Pager<Int, Photo>
}