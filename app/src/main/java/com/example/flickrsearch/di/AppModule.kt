package com.example.flickrsearch.di

import android.content.Context
import com.example.flickrsearch.data.local.AppDatabase
import com.example.flickrsearch.data.local.PhotoDao
import com.example.flickrsearch.data.remote.PhotoRemoteDataSource
import com.example.flickrsearch.data.remote.PhotoService
import com.example.flickrsearch.data.repository.PhotoRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.flickr.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): PhotoService = retrofit.create(PhotoService::class.java)

    @Singleton
    @Provides
    fun providePhotoRemoteDataSource(photoService: PhotoService) = PhotoRemoteDataSource(photoService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.photoDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: PhotoRemoteDataSource,
                          localDataSource: PhotoDao
    ) =
        PhotoRepository(remoteDataSource, localDataSource)
}