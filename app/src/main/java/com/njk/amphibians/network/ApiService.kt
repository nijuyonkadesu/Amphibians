package com.njk.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// 1. Base URL
private val BASE_URl = "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

// 2. moshi instance using KotlinJsonAdapter
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// 3. Retrofit instance using moshi
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URl)
    .build()

// 4. Interface on how to communicate with API service, defines the endpoint
interface ApiService {
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibian(): List<Amphibian>
}

// 5. Singleton object to access API service
object AmphibianApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}