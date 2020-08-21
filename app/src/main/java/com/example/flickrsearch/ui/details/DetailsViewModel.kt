package com.example.flickrsearch.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.flickrsearch.data.entities.Photo
import com.example.flickrsearch.data.repository.PhotoRepository
import com.example.flickrsearch.utils.Resource

class DetailsViewModel @ViewModelInject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    private val _id = MutableLiveData<String>()

    private val _photo = _id.switchMap { id ->
        repository.getPhoto(id)
    }
    val photo: LiveData<Resource<Photo>> = _photo


    fun start(id: String) {
        _id.value = id
    }

}