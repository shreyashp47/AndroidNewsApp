package com.shreyash.github.androidnewsapp

import android.app.Application
import com.shreyash.github.androidnewsapp.di.component.ApplicationComponent
import com.shreyash.github.androidnewsapp.di.component.DaggerApplicationComponent
import com.shreyash.github.androidnewsapp.di.module.ApplicationModule

class NewsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
         applicationComponent = DaggerApplicationComponent
             .builder()
             .applicationModule(ApplicationModule(this))
             .build()
        applicationComponent.inject(this)

    }
}