package com.github.bikkilshat.core_network.model.base

import com.github.bikkilshat.core_network.model.GameDto
import com.google.gson.annotations.SerializedName

/***
 * Базовая структура
 */
//Стандартный результат для всех страничек нашего IP (см. api.rawg.io/docs/  раздел games -> Response samples )
data class PagedResponse(
  @SerializedName("count") val count: Int, // сколько всего данных можно получить используя этот эндпоинт
  @SerializedName("next") val nextPageUrl: String, // дана ссылка что бы получить следующую страницу
  @SerializedName("previous") val previousPageUrl: String, // дана ссылка что бы получить предыдущую страницу
  @SerializedName("results") val results: List<GameDto>
)
