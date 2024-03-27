package com.gosport.test.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String,
) : Parcelable