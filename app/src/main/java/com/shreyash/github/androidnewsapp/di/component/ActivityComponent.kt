package com.shreyash.github.androidnewsapp.di.component

import com.shreyash.github.androidnewsapp.di.ActivityContext
import com.shreyash.github.androidnewsapp.di.ActivityScope
import com.shreyash.github.androidnewsapp.di.module.ActivityModule
import com.shreyash.github.androidnewsapp.ui.topheadline.TopHeadlineActivity
import dagger.Component
import javax.inject.Singleton


@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)
}