package com.gosport.test.di

import android.content.Context
import androidx.room.Room
import com.gosport.test.model.room.HistoryDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideDB(context: Context): HistoryDataBase =
        Room.databaseBuilder(context, HistoryDataBase::class.java, "history.db").build()
}