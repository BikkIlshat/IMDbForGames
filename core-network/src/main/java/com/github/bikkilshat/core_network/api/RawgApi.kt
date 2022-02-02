package com.github.bikkilshat.core_network.api

import com.github.bikkilshat.core_network.model.base.PagedResponse
import retrofit2.http.GET

interface RawgApi {
  @GET("/api/games")
  suspend fun games(): PagedResponse
}