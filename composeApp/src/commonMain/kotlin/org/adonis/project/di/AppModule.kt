package org.adonis.project.di

import org.adonis.project.ui.counter.CounterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    includes(networkModule, databaseModule, dataStoreModule)

    viewModelOf(::CounterViewModel)
}
