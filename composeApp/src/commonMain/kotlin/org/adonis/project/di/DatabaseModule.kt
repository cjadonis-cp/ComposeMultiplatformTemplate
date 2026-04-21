package org.adonis.project.di

import org.adonis.project.core.database.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single { get<DatabaseDriverFactory>().create() }
}
