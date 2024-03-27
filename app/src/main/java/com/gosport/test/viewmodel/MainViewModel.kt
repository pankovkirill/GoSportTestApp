package com.gosport.test.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gosport.test.mapCategoryDataModelToHistoryCategoryEntity
import com.gosport.test.mapMealDataModelToHistoryMealEntity
import com.gosport.test.model.data.AppState
import com.gosport.test.model.interactor.MainInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val interactor: MainInteractor
) : ViewModel() {

    private val _dataCategories = MutableStateFlow<AppState>(AppState.Empty)
    val dataCategories: StateFlow<AppState> = _dataCategories

    private val _dataMeal = MutableStateFlow<AppState>(AppState.Empty)
    val dataMeal: StateFlow<AppState> = _dataMeal

    fun getCategoriesData(isNetworkConnection: Boolean) = viewModelScope.launch {
        _dataCategories.value = (AppState.Loading)
        try {
            val responseData = interactor.getCategoriesData(isNetworkConnection)
            _dataCategories.value = responseData

            if (responseData is AppState.SuccessCategories) {
                responseData.data?.let {
                    interactor.saveCategoryToDb(mapCategoryDataModelToHistoryCategoryEntity(it))
                }
            }
        } catch (e: Throwable) {
            _dataCategories.value = (AppState.Error(e))
        }
    }

    fun getMealData(isNetworkConnection: Boolean) = viewModelScope.launch {
        _dataMeal.value = (AppState.Loading)
        try {
            val responseData = interactor.getMealData(isNetworkConnection)
            _dataMeal.value = responseData
            if (responseData is AppState.SuccessMeal) {
                responseData.data?.let {
                    interactor.saveMealToDb(mapMealDataModelToHistoryMealEntity(it))
                }
            }
        } catch (e: Throwable) {
            _dataMeal.value = (AppState.Error(e))
        }
    }

}