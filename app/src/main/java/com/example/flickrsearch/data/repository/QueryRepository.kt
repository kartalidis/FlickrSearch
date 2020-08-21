package com.example.flickrsearch.data.repository

import com.example.flickrsearch.data.entities.Query
import com.example.flickrsearch.data.entities.Recent
import com.example.flickrsearch.data.entities.Search
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

open class QueryRepository @Inject internal constructor() {
  private val queryTextRelay = BehaviorRelay.create<String>()

  open val latestQueryText: String? get() = queryTextRelay.value

  open val queries: Flowable<Query>
    get() = queryTextRelay
        .map {
          when (it.isBlank()) {
            true -> Recent
            false -> Search(it)
          }
        }
        .toFlowable(BackpressureStrategy.BUFFER)

  open fun putQueryText(queryText: String?) {
    queryTextRelay.accept(queryText ?: "")
  }
}
