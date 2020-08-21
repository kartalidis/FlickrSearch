package com.example.flickrsearch.data.remote

import com.example.flickrsearch.data.entities.Photo
import com.example.flickrsearch.data.entities.PhotoList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("services/rest/?method=flickr.photos.search&nojsoncallback=1&format=json")
    suspend fun getAllPhotos(
        @Query("api_key") apiKey: String,
        @Query("text") text: String? = null

    ) : Response<PhotoList>

    @GET("services/rest/?method=flickr.photos.getInfo&nojsoncallback=1&format=json")
    suspend fun getPhoto(
        @Query("api_key") apiKey: String,
        @Query("photo_id") id: String
    ): Response<Photo>
}