package com.gosport.test.model.repository

import com.gosport.test.model.room.HistoryCategoryEntity
import com.gosport.test.model.room.HistoryMealEntity

interface RepositoryLocal {

    suspend fun getCategoryData(): List<HistoryCategoryEntity>

    suspend fun saveCategoryToDb(entity: List<HistoryCategoryEntity>)

    suspend fun getMealData(): List<HistoryMealEntity>

    suspend fun saveMealToDb(entity: List<HistoryMealEntity>)

}