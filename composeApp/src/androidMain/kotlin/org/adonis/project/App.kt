package org.adonis.project

import android.app.Application
import org.adonis.project.di.appModule
import org.adonis.project.di.platformModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(appModule, platformModule)
        }
    }
}
