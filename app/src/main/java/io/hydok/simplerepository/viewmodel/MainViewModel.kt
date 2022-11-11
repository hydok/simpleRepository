package io.hydok.simplerepository.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.hydok.simplerepository.base.BaseViewModel
import io.hydok.simplerepository.model.Cat
import io.hydok.simplerepository.repository.CatRepository
import kotlinx.coroutines.flow.*


class MainViewModel(private val repository: CatRepository) : BaseViewModel() {

    val catsData: LiveData<List<Cat>> get() = _catsData
    private val _catsData = MutableLiveData<List<Cat>>()

    fun getCatsData() {
        launchViewModelScope {

            //basic
            /* showLoading()
             _catsData.postValue(repository.getCatsData())
             hideLoading()*/

            //flow
            repository.getCatsDataFlow()
                .onStart {
                    Log.d("MainViewModel", "onStart")
                    showLoading()
                }
                .onCompletion {
                    Log.d("MainViewModel", "onComplete")
                    hideLoading()
                }
                .catch { exception -> Log.d("MainViewModel", "onCatch $exception") }
                .collect {
                    Log.d("MainViewModel", it.toString())
                    _catsData.postValue(it)
                }
        }
    }
}