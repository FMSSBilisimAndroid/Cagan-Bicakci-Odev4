package com.caganbicakci.spaceexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.caganbicakci.spaceexplorer.service.SpaceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SpaceApi.retrofitService.getProperties().enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>){
                response.body()?.let { Log.v("PATIKA", it) }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

}