package com.gosport.test.model.interactor

import com.gosport.test.model.data.AppState
import com.gosport.test.model.room.HistoryCategoryEntity
import com.gosport.test.model.room.HistoryMealEntity

interface MainInteractor {
    suspend fun getCategoriesData(isNetworkConnection: Boolean): AppState
    suspend fun getMealData(isNetworkConnection: Boolean): AppState
    suspend fun saveMealToDb(entity: List<HistoryMealEntity>)
    suspend fun saveCategoryToDb(entity: List<HistoryCategoryEntity>)
}