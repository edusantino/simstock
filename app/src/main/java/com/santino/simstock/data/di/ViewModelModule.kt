package com.santino.simstock.data.di

import com.santino.simstock.ui.home.HomeViewModel
import com.santino.simstock.ui.home.HomeViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<HomeViewModel> { HomeViewModelImpl(get()) }
}