package com.santino.simstock.data.di

import com.santino.simstock.data.HomeRepository
import com.santino.simstock.data.HomeRepositoryImpl
import com.santino.simstock.data.utils.GeneratorCalc
import org.koin.dsl.module

val repositoryModule = module {
    single { GeneratorCalc() }
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}