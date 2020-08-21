package com.example.flickrsearch.data.remote


import javax.inject.Inject

class PhotoRemoteDataSource @Inject constructor(
    private val photoService: PhotoService
): BaseDataSource() {

    suspend fun getPhotos() = getResult { photoService.getAllPhotos(API_KEY) }
    suspend fun getPhoto(id: String) = getResult { photoService.getPhoto(API_KEY, id) }
}