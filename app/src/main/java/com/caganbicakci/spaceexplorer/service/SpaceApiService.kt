package com.caganbicakci.spaceexplorer.service

import com.caganbicakci.spaceexplorer.model.PlanetModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SpaceApiService {

    @Headers(
        "X-RapidAPI-Key:a3e3bb06f7msh580e911de10f207p1097ccjsn75569fed2ece",
        "X-RapidAPI-Host:planets-info-by-newbapi.p.rapidapi.com"
    )
    @GET("planet/list")
    fun getProperties(): Call<List<PlanetModel>>
}
