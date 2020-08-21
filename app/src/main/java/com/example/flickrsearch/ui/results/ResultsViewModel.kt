package com.example.rickandmorty.ui.characters

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.flickrsearch.data.repository.PhotoRepository

class CharactersViewModel @ViewModelInject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    val photos = repository.getPhotos()
}
