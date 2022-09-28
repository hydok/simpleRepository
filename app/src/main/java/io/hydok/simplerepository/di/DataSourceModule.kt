package io.hydok.simplerepository.di


import io.hydok.simplerepository.data.LocalDataSource
import io.hydok.simplerepository.data.LocalDataSourceImpl
import io.hydok.simplerepository.data.RemoteDataSource
import io.hydok.simplerepository.data.RemoteDataSourceImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LocalDataSource> { LocalDataSourceImpl()}
}

