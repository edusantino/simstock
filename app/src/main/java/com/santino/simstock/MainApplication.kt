package com.santino.simstock

import android.app.Application
import androidx.room.Room
import com.santino.simstock.data.datasource.AppDatabase
import com.santino.simstock.data.di.persistenceModule
import com.santino.simstock.data.di.repositoryModule
import com.santino.simstock.data.di.tokenModule
import com.santino.simstock.data.di.viewModelModule
import com.santino.simstock.data.utils.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(
                persistenceModule,
                repositoryModule,
                viewModelModule,
                tokenModule,
            ))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun getDBModule() = module {
        val db =  Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

        single {
            db.companyDao()
        }
    }
}