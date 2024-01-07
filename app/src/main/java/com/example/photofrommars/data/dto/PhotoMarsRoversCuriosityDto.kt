package com.example.photofrommars.data.dto

import com.example.photofrommars.entity.Camera
import com.example.photofrommars.entity.CamerasRover
import com.example.photofrommars.entity.Photo
import com.example.photofrommars.entity.PhotoMarsRoversCuriosity
import com.example.photofrommars.entity.Rover
import javax.inject.Inject

class PhotoMarsRoversCuriosityDto (
    override val photos: List<PhotoDto>
) : PhotoMarsRoversCuriosity

class PhotoDto(
    override val id: Int,
    override val sol: Int,
    override val camera: CameraDto,
    override val img_src: String,
    override val earth_date: String,
    override val rover: RoverDto
) : Photo

class CameraDto(
    override val id: Int,
    override val name: String,
    override val roverId: Int,
    override val fullName: String
) : Camera

class RoverDto(
    override val id: Int,
    override val name: String,
    override val landingDate: String,
    override val launchDate: String,
    override val status: String,
    override val maxSol: Int,
    override val maxDate: String,
    override val totalPhotos: Int,
    override val cameras: List<CamerasRoverDto>
) : Rover

class CamerasRoverDto(
    override val name: String,
    override val fullName: String
    ) : CamerasRover