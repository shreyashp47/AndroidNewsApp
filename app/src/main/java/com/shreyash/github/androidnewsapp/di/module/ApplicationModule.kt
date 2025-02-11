package com.shreyash.github.androidnewsapp.di.module

import android.content.Context
import com.shreyash.github.androidnewsapp.NewsApplication
import com.shreyash.github.androidnewsapp.di.ApplicationContext
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(private val application: NewsApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

}