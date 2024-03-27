package com.gosport.test.di

import com.gosport.test.model.data.api.ApiService
import com.gosport.test.model.repository.RepositoryLocal
import com.gosport.test.model.repository.RepositoryLocalImpl
import com.gosport.test.model.repository.RepositoryRemote
import com.gosport.test.model.repository.RepositoryRemoteImpl
import com.gosport.test.model.room.HistoryDataBase
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {
    @Reusable
    @Provides
    fun provideRepositoryLocal(db: HistoryDataBase): RepositoryLocal = RepositoryLocalImpl(db)

    @Reusable
    @Provides
    fun provideRepositoryRemote(api: ApiService): RepositoryRemote = RepositoryRemoteImpl(api)
}