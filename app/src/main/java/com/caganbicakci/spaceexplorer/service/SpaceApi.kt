package com.caganbicakci.spaceexplorer.service
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object SpaceApi {

    private const val BASE_URL = "https://planets-info-by-newbapi.p.rapidapi.com/api/v1/"

    private val moshi = Moshi.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        //.addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val retrofitService: SpaceApiService by lazy {
        retrofit.create(SpaceApiService::class.java)
    }


}