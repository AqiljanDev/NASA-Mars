package com.example.cleancode.data.dataSource

import com.example.cleancode.data.dto.PhotoMarsRoversCuriosityDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val NASA_URL = "https://api.nasa.gov"
private const val API_KEY = "u8eY9Nh8DgRiaNrDuR6aWzanppD9yAi55QZ2gfjI"

interface PhotoMarsRoversCuriosityApi {

    @GET("/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=$API_KEY")
    suspend fun getPhoto(@Query("page") page: Int): PhotoMarsRoversCuriosityDto
}

val retrofit: PhotoMarsRoversCuriosityApi = Retrofit.Builder()
    .baseUrl(NASA_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(PhotoMarsRoversCuriosityApi::class.java)
