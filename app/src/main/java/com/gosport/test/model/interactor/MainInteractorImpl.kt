package com.gosport.test.model.interactor

import com.gosport.test.mapHistoryCategoryEntityToCategoryDataModel
import com.gosport.test.mapHistoryMealEntityToMealDataModel
import com.gosport.test.model.data.AppState
import com.gosport.test.model.repository.RepositoryLocal
import com.gosport.test.model.repository.RepositoryRemote
import com.gosport.test.model.room.HistoryCategoryEntity
import com.gosport.test.model.room.HistoryMealEntity
import javax.inject.Inject

class MainInteractorImpl
@Inject constructor(
    private val repositoryRemote: RepositoryRemote,
    private val repositoryLocal: RepositoryLocal,
) : MainInteractor {

    override suspend fun saveMealToDb(entity: List<HistoryMealEntity>) {
        repositoryLocal.saveMealToDb(entity)
    }

    override suspend fun saveCategoryToDb(entity: List<HistoryCategoryEntity>) {
        repositoryLocal.saveCategoryToDb(entity)
    }

    override suspend fun getCategoriesData(isNetworkConnection: Boolean): AppState {
        return AppState.SuccessCategories(
            if (isNetworkConnection)
                repositoryRemote.getCategoriesData()
            else
                mapHistoryCategoryEntityToCategoryDataModel(repositoryLocal.getCategoryData())
        )
    }

    override suspend fun getMealData(isNetworkConnection: Boolean): AppState {
        return AppState.SuccessMeal(
            if (isNetworkConnection)
                repositoryRemote.getMealData()
            else
                mapHistoryMealEntityToMealDataModel(repositoryLocal.getMealData())
        )
    }


}