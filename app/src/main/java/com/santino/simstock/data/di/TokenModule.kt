package com.santino.simstock.data.di

import com.santino.simstock.data.service.TokenService
import org.koin.dsl.module

val tokenModule = module {
    single { TokenService(get()) }
}