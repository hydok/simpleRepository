package io.hydok.simplerepository.di


import io.hydok.simplerepository.repository.Repository
import io.hydok.simplerepository.repository.RepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
}

