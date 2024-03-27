package com.gosport.test.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [HistoryMealEntity::class, HistoryCategoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class HistoryDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}