package org.adonis.project

import org.adonis.project.di.appModule
import org.adonis.project.di.platformModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule, platformModule)
    }
}
