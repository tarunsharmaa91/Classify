package com.app.classify.network

import com.app.classify.model.ClassifyAd
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/"

interface ApiService {
    @GET("dynamodb-writer")
    suspend fun getAds(): ClassifyAd
}

object AdsApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()