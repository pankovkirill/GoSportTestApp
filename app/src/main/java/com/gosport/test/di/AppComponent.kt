package com.gosport.test.di

import android.content.Context
import com.gosport.test.view.menu.MenuFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DBModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        InteractorModule::class,
        ViewModelModule::class,
    ]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(menuFragment: MenuFragment)
}