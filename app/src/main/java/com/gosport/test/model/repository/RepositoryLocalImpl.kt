package com.gosport.test.model.repository

import com.gosport.test.model.room.HistoryCategoryEntity
import com.gosport.test.model.room.HistoryDataBase
import com.gosport.test.model.room.HistoryMealEntity
import javax.inject.Inject

class RepositoryLocalImpl
@Inject constructor(
    private val favoriteDataBase: HistoryDataBase
) : RepositoryLocal {
    override suspend fun getMealData(): List<HistoryMealEntity> {
        return favoriteDataBase.historyDao().allMeal()
    }

    override suspend fun getCategoryData(): List<HistoryCategoryEntity> {
        return favoriteDataBase.historyDao().allCategory()
    }

    override suspend fun saveMealToDb(entity: List<HistoryMealEntity>) {
        favoriteDataBase.historyDao().insertMeal(entity)
    }

    override suspend fun saveCategoryToDb(entity: List<HistoryCategoryEntity>) {
        favoriteDataBase.historyDao().insertCategory(entity)
    }
}