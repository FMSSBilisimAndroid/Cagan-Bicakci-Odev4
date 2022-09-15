package com.caganbicakci.spaceexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.caganbicakci.spaceexplorer.model.PlanetModel
import com.caganbicakci.spaceexplorer.service.SpaceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SpaceApi.retrofitService.getProperties().enqueue(object: Callback<List<PlanetModel>> {
            override fun onResponse(call: Call<List<PlanetModel>>, response: Response<List<PlanetModel>>){
                response.body()?.let { Log.v("SPACE", it.toString()) }
            }

            override fun onFailure(call: Call<List<PlanetModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}