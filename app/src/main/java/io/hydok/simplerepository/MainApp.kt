package io.hydok.simplerepository

import android.app.Application
import android.content.Context
import io.hydok.simplerepository.di.dataSourceModule
import io.hydok.simplerepository.di.networkModule
import io.hydok.simplerepository.di.repositoryModule
import io.hydok.simplerepository.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {

    lateinit var applicationCtx: Context

    companion object {
        lateinit var INSTANCE: MainApp
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()

        applicationCtx = applicationContext
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule,
                    dataSourceModule
                )
            )
        }
    }

}