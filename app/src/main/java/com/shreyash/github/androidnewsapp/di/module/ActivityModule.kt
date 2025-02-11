package com.shreyash.github.androidnewsapp.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.shreyash.github.androidnewsapp.di.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(private val activity : AppCompatActivity) { //dependency provider

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }
}