package com.caganbicakci.spaceexplorer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.caganbicakci.spaceexplorer.databinding.FragmentHomeBinding
import com.caganbicakci.spaceexplorer.model.PlanetModel
import com.caganbicakci.spaceexplorer.service.SpaceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        SpaceApi.retrofitService.getProperties().enqueue(object: Callback<List<PlanetModel>> {
            override fun onResponse(call: Call<List<PlanetModel>>, response: Response<List<PlanetModel>>){
                response.body()?.let { responseList ->
                    fragmentHomeBinding.tvTest.text = responseList[0].name
                }
            }

            override fun onFailure(call: Call<List<PlanetModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}