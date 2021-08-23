package com.study.kotlin.aliveinlive

import android.app.Application
import com.study.kotlin.aliveinlive.koin.modules.mainModule

import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidLogger
import org.koin.android.ext.koin.androidContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(mainModule)
        }
    }
}