package com.caganbicakci.spaceexplorer.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.spaceexplorer.BR
import com.caganbicakci.spaceexplorer.databinding.PlanetItemBinding
import com.caganbicakci.spaceexplorer.model.PlanetModel

class PlanetsViewHolder(
    private val planetBinding: ViewDataBinding
): RecyclerView.ViewHolder(planetBinding.root) {

    fun onBind(planetModel: PlanetModel){
        val binding = planetBinding as PlanetItemBinding
        binding.setVariable(BR.planetModel, planetModel)

    }
}