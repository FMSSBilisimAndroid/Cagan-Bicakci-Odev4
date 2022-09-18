package com.caganbicakci.spaceexplorer.recyclerview

import com.caganbicakci.spaceexplorer.model.PlanetModel

interface PlanetClickHandler {
    fun clickedPlanetItem(planetModel: PlanetModel)
}