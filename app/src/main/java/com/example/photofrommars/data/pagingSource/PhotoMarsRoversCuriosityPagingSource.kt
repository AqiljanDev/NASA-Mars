package com.example.photofrommars.data.pagingSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.photofrommars.data.dataSource.RoversCuriosityDataSource
import com.example.photofrommars.entity.Photo
import com.example.photofrommars.entity.PhotoMarsRoversCuriosity
import javax.inject.Inject

class PhotoMarsRoversCuriosityPagingSource @Inject constructor(
    private val roversCuriosityDataSource: RoversCuriosityDataSource
    ) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        var page = params.key ?: 1
        roversCuriosityDataSource.getList(1).forEach {
            Log.d("Mylog", "DS = ${it.id}")
        }

        return kotlin.runCatching {
            roversCuriosityDataSource.getList(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = { LoadResult.Error(it) }
        )
    }

}