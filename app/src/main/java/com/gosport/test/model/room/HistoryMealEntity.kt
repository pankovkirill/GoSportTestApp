package com.gosport.test.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class HistoryMealEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val idMeal: String = "",
    @ColumnInfo(name = "meal")
    val strMeal: String? = "",
    @ColumnInfo(name = "category")
    val strCategory: String? = "",
    @ColumnInfo(name = "instructions")
    val strInstructions: String? = "",
    @ColumnInfo(name = "mealthumb")
    val strMealThumb: String? = "",
    @ColumnInfo(name = "strtags")
    val strTags: String? = "",
)