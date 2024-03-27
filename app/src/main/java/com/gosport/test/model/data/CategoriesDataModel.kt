package com.gosport.test.model.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoriesDataModel(
    val categories: List<Category>
): Parcelable