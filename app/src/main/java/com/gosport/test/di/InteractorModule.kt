package com.gosport.test.di

import com.gosport.test.model.interactor.MainInteractor
import com.gosport.test.model.interactor.MainInteractorImpl
import com.gosport.test.model.repository.RepositoryLocal
import com.gosport.test.model.repository.RepositoryRemote
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class InteractorModule {
    @Provides
    @Reusable
    fun provideMainInteractor(
        repositoryRemote: RepositoryRemote,
        repositoryLocal: RepositoryLocal
    ): MainInteractor = MainInteractorImpl(repositoryRemote, repositoryLocal)
}