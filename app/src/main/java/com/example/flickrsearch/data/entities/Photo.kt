package com.example.flickrsearch.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo (
    val title: String,
    val ownerName: String,
    val description: String,
    @PrimaryKey
    val id: String,
    val thumbnail: String,
    val image: String
)