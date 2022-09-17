package com.caganbicakci.spaceexplorer

import com.caganbicakci.spaceexplorer.model.PlanetModel

interface PlanetClickHandler {
    fun clickedPlanetItem(planetModel: PlanetModel)
}