package com.shreyash.github.androidnewsapp.di.component

import com.shreyash.github.androidnewsapp.NewsApplication
import com.shreyash.github.androidnewsapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsApplication)


}