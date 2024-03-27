package com.gosport.test.model.repository

import com.gosport.test.model.data.CategoriesDataModel
import com.gosport.test.model.data.MealDataModel
import com.gosport.test.model.data.api.ApiService
import javax.inject.Inject

class RepositoryRemoteImpl
@Inject constructor(private val apiService: ApiService) : RepositoryRemote {

    override suspend fun getCategoriesData(): CategoriesDataModel {
        return apiService.getCategoriesAsync().await()
    }

    override suspend fun getMealData(): MealDataModel {
        return apiService.getSearchAsync().await()
    }
}