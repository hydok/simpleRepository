package io.hydok.simplerepository.di


import io.hydok.simplerepository.data.RemoteDataSource
import io.hydok.simplerepository.data.RemoteDataSourceImpl
import io.hydok.simplerepository.repository.Repository
import io.hydok.simplerepository.repository.RepositoryImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
}

