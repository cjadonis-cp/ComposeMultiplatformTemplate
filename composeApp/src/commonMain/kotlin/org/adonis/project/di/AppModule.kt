package org.adonis.project.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule, databaseModule, dataStoreModule)
}
