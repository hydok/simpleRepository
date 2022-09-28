package io.hydok.simplerepository.di



import io.hydok.simplerepository.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module{
    viewModel {MainViewModel(get())}
}
