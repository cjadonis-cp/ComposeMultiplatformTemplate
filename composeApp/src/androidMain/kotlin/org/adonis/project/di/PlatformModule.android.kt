package org.adonis.project.di

import org.adonis.project.core.database.DatabaseDriverFactory
import org.adonis.project.core.datastore.createDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val platformModule = module {
    single { DatabaseDriverFactory(androidContext()) }
    single { createDataStore(androidContext()) }
}
