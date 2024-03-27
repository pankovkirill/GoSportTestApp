package com.gosport.test

import com.gosport.test.model.data.CategoriesDataModel
import com.gosport.test.model.data.Category
import com.gosport.test.model.data.Meal
import com.gosport.test.model.data.MealDataModel
import com.gosport.test.model.room.HistoryCategoryEntity
import com.gosport.test.model.room.HistoryMealEntity

fun mapHistoryMealEntityToMealDataModel(mealData: List<HistoryMealEntity>): MealDataModel {
    return MealDataModel(mealData.map {
        Meal(it.idMeal.toString(), it.strMeal.toString(), it.strCategory.toString(), it.strInstructions.toString(), it.strMealThumb.toString(), it.strTags.toString())
    })
}

fun mapHistoryCategoryEntityToCategoryDataModel(categoryData: List<HistoryCategoryEntity>): CategoriesDataModel {
    return CategoriesDataModel(categoryData.map {
        Category(it.idCategory.toString(), it.strCategory.toString())
    })
}

fun mapMealDataModelToHistoryMealEntity(data: MealDataModel): List<HistoryMealEntity> {
    return data.meals.map {
        HistoryMealEntity(
            it.idMeal,
            it.strMeal,
            it.strCategory,
            it.strInstructions,
            it.strMealThumb,
            it.strTags
        )
    }
}

fun mapCategoryDataModelToHistoryCategoryEntity(data: CategoriesDataModel): List<HistoryCategoryEntity> {
    return data.categories.map {
        HistoryCategoryEntity(it.idCategory, it.strCategory)
    }
}