package com.caganbicakci.spaceexplorer.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.caganbicakci.spaceexplorer.BR
import com.caganbicakci.spaceexplorer.PlanetClickHandler
import com.caganbicakci.spaceexplorer.PlanetItemDecoration
import com.caganbicakci.spaceexplorer.databinding.FragmentPlanetBinding
import com.caganbicakci.spaceexplorer.model.PlanetModel
import com.caganbicakci.spaceexplorer.recyclerview.PlanetAdapter
import com.caganbicakci.spaceexplorer.service.SpaceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetFragment : Fragment(), PlanetClickHandler {

    private lateinit var fragmentPlanetBinding: FragmentPlanetBinding
    //private lateinit var planetList: List<PlanetModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentPlanetBinding = FragmentPlanetBinding.inflate(inflater)
        return fragmentPlanetBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clickHandler = this

        SpaceApi.retrofitService.getProperties().enqueue(object: Callback<List<PlanetModel>> {
            override fun onResponse(call: Call<List<PlanetModel>>, response: Response<List<PlanetModel>>){
                response.body()?.let { responseList ->
                    val adapter = PlanetAdapter(responseList,clickHandler)
                    val gridLayoutManager = GridLayoutManager(context, 2)

                    fragmentPlanetBinding.apply {
                        recyclerView.layoutManager = gridLayoutManager
                        recyclerView.addItemDecoration(PlanetItemDecoration(20))
                        setVariable(BR.adapter,adapter)
                    }
                }
            }

            override fun onFailure(call: Call<List<PlanetModel>>, t: Throwable) {
                Log.e("RETROFIT", "Some error!")
            }

        })
    }

    override fun clickedPlanetItem(planetModel: PlanetModel) {
        findNavController().apply {
            val action = PlanetFragmentDirections.actionPlanetFragmentToPlanetDetailFragment(planetModel)
            navigate(action)
        }
    }

}