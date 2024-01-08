package com.example.cleancode.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cleancode.data.dataSource.RoversCuriosityDataSource
import com.example.cleancode.domain.entity.Photo
import javax.inject.Inject

class PhotoMarsRoversCuriosityPagingSource @Inject constructor(
    private val roversCuriosityDataSource: RoversCuriosityDataSource
    ) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val page = params.key ?: 1

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