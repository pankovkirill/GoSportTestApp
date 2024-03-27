package com.gosport.test.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("select * from meal")
    suspend fun allMeal(): List<HistoryMealEntity>

    @Query("select * from category")
    suspend fun allCategory(): List<HistoryCategoryEntity>

    @Insert(onConflict = REPLACE)
    suspend fun insertMeal(entity: List<HistoryMealEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun insertCategory(entity: List<HistoryCategoryEntity>)


}