package com.gosport.test.model.data

sealed class AppState {
    data class SuccessCategories(val data: CategoriesDataModel?) : AppState()
    data class SuccessMeal(val data: MealDataModel?) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
    object Empty : AppState()
}
