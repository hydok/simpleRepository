package io.hydok.simplerepository

import android.app.Application
import io.hydok.simplerepository.di.networkModule
import io.hydok.simplerepository.di.repositoryModule
import io.hydok.simplerepository.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {


    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }

}