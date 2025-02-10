package com.shreyash.github.androidnewsapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {

    val main: CoroutineDispatcher // UI-related tasks

    val io: CoroutineDispatcher // Network calls, File I/O

    val default: CoroutineDispatcher // CPU-intensive tasks (not usually for DB)

}

class DefaultDispatcherProvider : DispatcherProvider {

    override val main: CoroutineDispatcher
        get() = Dispatchers.Main

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

}