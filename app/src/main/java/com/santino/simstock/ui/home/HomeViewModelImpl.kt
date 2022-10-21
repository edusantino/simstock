package com.santino.simstock.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.santino.simstock.data.HomeRepository
import com.santino.simstock.data.models.Company
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val homeRepository: HomeRepository
) : HomeViewModel() {
    override val loadState = MutableLiveData(false)
    override val listCompanies =  MutableLiveData<List<Company>>()

    override fun loadCompanies() {
        viewModelScope.launch {
            loadState.postValue(true)
            try {
                val companies = homeRepository.getAllCompanies()
                listCompanies.postValue(companies)
            } catch (t: Throwable) {
                Log.e(TAG, "error on load: $t", )
            } finally {
                loadState.postValue(false)
            }
        }
    }

    override fun generateData() {
        viewModelScope.launch {
            loadState.postValue(true)
            try {
                homeRepository.initCompaniesData()
                loadCompanies()
            } catch (t: Throwable) {
                Log.e(TAG, "error on load: $t", )
            } finally {
                loadState.postValue(false)
            }
        }
    }

    companion object {
        private const val TAG = "loadCompanies"
    }
}