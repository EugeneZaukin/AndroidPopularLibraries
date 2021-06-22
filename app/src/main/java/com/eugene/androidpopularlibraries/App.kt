package com.eugene.androidpopularlibraries

import android.app.Application
import com.eugene.androidpopularlibraries.di.AppComponent
import com.eugene.androidpopularlibraries.di.AppModule
import com.eugene.androidpopularlibraries.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}