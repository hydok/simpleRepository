package io.hydok.simplerepository.di


import io.hydok.simplerepository.repository.CatRepository
import io.hydok.simplerepository.repository.CatRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single<CatRepository> { CatRepositoryImpl(get(),get()) }
}

