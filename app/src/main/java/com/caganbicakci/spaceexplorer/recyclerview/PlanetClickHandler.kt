package com.caganbicakci.spaceexplorer.recyclerview
import com.caganbicakci.spaceexplorer.model.PlanetModel

/**
 * click handler interface created for handle click event
 * for each item in recycler view.
 *
 */

interface PlanetClickHandler {
    fun clickedPlanetItem(planetModel: PlanetModel)
}