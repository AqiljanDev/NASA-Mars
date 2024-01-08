package com.example.photofrommars.presentation.listPhotoMars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.cleancode.domain.useCase.GetMarsPhotoCuriosityUseCase
import com.example.cleancode.domain.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListPhotoMarsViewModel @Inject constructor(
    private val getMarsPhotoCuriosityUseCase: GetMarsPhotoCuriosityUseCase
) : ViewModel() {
    private val _listPhotoMars: MutableStateFlow<PagingData<Photo>> = MutableStateFlow(value = PagingData.empty())
    val listPhotoMars get() = _listPhotoMars.asStateFlow()

    init {
        getListPhotoMars()
    }

    fun getListPhotoMars() {
        viewModelScope.launch {
            getMarsPhotoCuriosityUseCase.execute().flow
                .cachedIn(viewModelScope)
                .collect{
                    _listPhotoMars.value = it
                }
        }
    }
}