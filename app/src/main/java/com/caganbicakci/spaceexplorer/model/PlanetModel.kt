package com.caganbicakci.spaceexplorer.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlanetModel(
    val basicDetails: List<BasicDetail>,
    val description: String,
    val id: Long,
    val imgSrc: List<ImgSrc>,
    val key: String,
    val name: String,
    val planetOrder: String,
    val source: String,
    val wikiLink: String
) : Parcelable

@Parcelize
data class BasicDetail(
    val mass: String,
    val volume: String
): Parcelable

@Parcelize
data class ImgSrc(
    val img: String,
    val imgDescription: String
): Parcelable
