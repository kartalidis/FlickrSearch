package com.example.flickrsearch.data.repository

import com.example.flickrsearch.data.local.PhotoDao
import com.example.flickrsearch.data.remote.PhotoRemoteDataSource
import com.example.flickrsearch.utils.performGetOperation
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val remoteDataSource: PhotoRemoteDataSource,
    private val localDataSource: PhotoDao
){

    fun getPhoto(id: String) = performGetOperation(
        databaseQuery = { localDataSource.getPhoto(id) },
        networkCall = { remoteDataSource.getPhoto(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getPhotos() = performGetOperation(
        databaseQuery = { localDataSource.getAllPhotos() },
        networkCall = { remoteDataSource.getPhotos() },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}