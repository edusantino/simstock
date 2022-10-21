package com.santino.simstock.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.santino.simstock.data.models.Company

abstract class HomeViewModel : ViewModel() {
    abstract val loadState: LiveData<Boolean>
    abstract val listCompanies: LiveData<List<Company>>

    abstract fun loadCompanies()
    abstract fun generateData()
}