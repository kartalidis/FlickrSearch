package com.example.flickrsearch.data.entities

sealed class Query

object Recent : Query()

data class Search(val queryText: String) : Query()