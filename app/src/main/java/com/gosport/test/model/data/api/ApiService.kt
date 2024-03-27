package com.gosport.test.model.data.api

import com.gosport.test.model.data.CategoriesDataModel
import com.gosport.test.model.data.MealDataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/api/json/v1/1/search.php?s")
    fun getSearchAsync(): Deferred<MealDataModel>

    @GET("/api/json/v1/1/categories.php")
    fun getCategoriesAsync(): Deferred<CategoriesDataModel>
}