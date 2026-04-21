package org.adonis.project.di

import org.adonis.project.core.network.HttpClientFactory
import org.koin.dsl.module

val networkModule = module {
    single { HttpClientFactory.create() }
}
