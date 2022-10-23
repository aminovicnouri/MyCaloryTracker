package com.aminovic.tracker_data.mapper

import com.aminovic.tracker_data.remote.dto.Product
import com.aminovic.tracker_domain.model.TrackableFood
import kotlin.math.roundToInt

fun Product.toTrackableFood(): TrackableFood? {
    val carbsPer100g = nutriments.carbohydrates100g.roundToInt()
    val proteinsPer100g = nutriments.proteins100g.roundToInt()
    val fatsPer100g = nutriments.fat100g.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g.roundToInt()
    return TrackableFood(
        name = productName ?: return null,
        caloriesPer100g = caloriesPer100g,
        proteinPer100g = proteinsPer100g,
        carbsPer100g = carbsPer100g,
        fatPer100g = fatsPer100g,
        imageUrl = imageFrontThumbUrl
    )
}
