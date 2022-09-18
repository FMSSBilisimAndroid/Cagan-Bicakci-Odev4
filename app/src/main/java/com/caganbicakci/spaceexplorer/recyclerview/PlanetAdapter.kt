package com.caganbicakci.spaceexplorer.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.caganbicakci.spaceexplorer.BR
import com.caganbicakci.spaceexplorer.R
import com.caganbicakci.spaceexplorer.databinding.PlanetItemBinding
import com.caganbicakci.spaceexplorer.model.PlanetModel

class PlanetAdapter(private val planetList: List<PlanetModel>,
private val clickHandler: PlanetClickHandler
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val planetsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.planet_item, parent, false
        )
        return PlanetsViewHolder(planetsBinding)
    }

    override fun getItemCount(): Int {
        return planetList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlanetsViewHolder).onBind(planetList[position])
    }

    inner class PlanetsViewHolder(
        private val planetBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(planetBinding.root), View.OnClickListener{

        init {
            planetBinding.root.setOnClickListener(this)
        }

        fun onBind(planetModel: PlanetModel){
            val binding = planetBinding as PlanetItemBinding
            binding.setVariable(BR.planetModel, planetModel)
        }

        override fun onClick(v: View?) {
            val position = bindingAdapterPosition
            clickHandler.clickedPlanetItem(planetList[position])
        }
    }

}