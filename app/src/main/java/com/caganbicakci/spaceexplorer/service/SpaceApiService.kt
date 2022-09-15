package com.caganbicakci.spaceexplorer.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SpaceApiService {


    @Headers(
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
    )
    @GET("realestate")
    fun getProperties(): Call<String>
}