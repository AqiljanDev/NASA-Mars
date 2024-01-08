package com.example.cleancode.domain.entity

interface PhotoMarsRoversCuriosity {
    val photos: List<Photo>
}

interface Photo {
    val id: Int
    val sol: Int
    val camera: Camera
    val img_src: String
    val earth_date: String
    val rover: Rover
}

interface Camera {
    val id: Int
    val name: String
    val roverId: Int
    val fullName: String
}

interface Rover {
    val id: Int
    val name: String
    val landingDate: String
    val launchDate: String
    val status: String
    val maxSol: Int
    val maxDate: String
    val totalPhotos: Int
    val cameras: List<CamerasRover>
}

interface CamerasRover{
    val name: String
    val fullName: String
}