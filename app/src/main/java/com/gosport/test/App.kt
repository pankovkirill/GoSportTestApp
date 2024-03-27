package com.gosport.test

import android.app.Application
import com.gosport.test.di.AppComponent
import com.gosport.test.di.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        component = DaggerAppComponent.builder()
            .setContext(this)
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}