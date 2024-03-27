package com.gosport.test.model.repository

import com.gosport.test.model.data.CategoriesDataModel
import com.gosport.test.model.data.MealDataModel

interface RepositoryRemote {
    suspend fun getCategoriesData(): CategoriesDataModel
    suspend fun getMealData(): MealDataModel
}