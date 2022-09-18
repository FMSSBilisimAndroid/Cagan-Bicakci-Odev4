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
import com.caganbicakci.spaceexplorer.recyclerview.PlanetClickHandler
import com.caganbicakci.spaceexplorer.recyclerview.PlanetItemDecoration
import com.caganbicakci.spaceexplorer.databinding.FragmentPlanetBinding
import com.caganbicakci.spaceexplorer.model.PlanetModel
import com.caganbicakci.spaceexplorer.recyclerview.PlanetAdapter
import com.caganbicakci.spaceexplorer.service.SpaceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetFragment : Fragment(), PlanetClickHandler {

    private lateinit var fragmentPlanetBinding: FragmentPlanetBinding
    private val clickHandler = this

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
        getPlanets()
    }

    /**
     * Clicked planet item passed with safe arguments to detail page.
     */
    override fun clickedPlanetItem(planetModel: PlanetModel) {
        findNavController().apply {
            val action =
                PlanetFragmentDirections.actionPlanetFragmentToPlanetDetailFragment(planetModel)
            navigate(action)
        }
    }

    private fun getPlanets() {

        /**
         * initial value of progress bar was [View.GONE]
         * While getting planets data first it shows progress bar by setting visibility as [View.VISIBLE]
         * Then with [SpaceApi.retrofitService] getProperties() method it gets the planets data.
         * if response body is not null create adapter with responseList.
         * Finally set progress bar visibility to [View.GONE]
         */

        fragmentPlanetBinding.spaceLoading.visibility = View.VISIBLE

        SpaceApi.retrofitService.getProperties().enqueue(object : Callback<List<PlanetModel>> {
            override fun onResponse(
                call: Call<List<PlanetModel>>,
                response: Response<List<PlanetModel>>
            ) {
                response.body()?.let { responseList ->
                    val adapter = PlanetAdapter(responseList, clickHandler)
                    val gridLayoutManager = GridLayoutManager(context, 2)

                    fragmentPlanetBinding.apply {
                        recyclerView.layoutManager = gridLayoutManager
                        recyclerView.addItemDecoration(PlanetItemDecoration(20))
                        setVariable(BR.adapter, adapter)
                        spaceLoading.visibility = View.GONE
                    }
                }
            }

            override fun onFailure(call: Call<List<PlanetModel>>, t: Throwable) {
                Log.e("RETROFIT", "Error occurred!")
            }

        })
    }

}