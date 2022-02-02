package com.github.bikkilshat.core_network.di

import com.github.bikkilshat.core_network.BuildConfig
import com.github.bikkilshat.core_network.api.RawgApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***
 * Временная реализация пока нет Dagger2
 */
private const val BASE_URL = "https://api.rawg.io/"

class NetworkComponent {
  companion object {
    private const val BASE_URL = "https://api.rawg.io/"


    fun createApi(): RawgApi {
      return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
          OkHttpClient.Builder()
            .addInterceptor { chain ->
              val original = chain.request()
              val request = original.newBuilder()
                .header("api_key", "c06cc4f7d33a4d9f96f930573d2d7326")
                .method(original.method, original.body)
                .build()
              chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().apply {
              level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            .build()
        )
        .build()
        .create(RawgApi::class.java)
    }
  }

 }


