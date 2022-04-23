package com.github.bikkilshat.core_network.model

import com.google.gson.annotations.SerializedName


/***
 *  описали  минимально поля поля которые отдают для запросов  :
 *  GET https://api.rawg.io/api/games?dates=2019-09-01,2019-09-30&platforms=18,1,7
 */
data class GameDto(
  @SerializedName("id") val id: Long,
  @SerializedName("name") val title: String,
  @SerializedName("background_image") val image: String
)
