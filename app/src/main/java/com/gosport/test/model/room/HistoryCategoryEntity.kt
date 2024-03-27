package com.gosport.test.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class HistoryCategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val idCategory: String = "",
    @ColumnInfo(name = "category")
    val strCategory: String? = ""
)