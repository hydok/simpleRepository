package io.hydok.simplerepository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.hydok.simplerepository.base.BaseViewModel
import io.hydok.simplerepository.model.Cat
import io.hydok.simplerepository.repository.Repository


class MainViewModel(private val repository: Repository) : BaseViewModel() {

    val catsData: LiveData<List<Cat>> get() = _catsData
    private val _catsData = MutableLiveData<List<Cat>>()

    fun getCatsData() {
        launchViewModelScope {
            repository.getCatsData()
        }
    }
}