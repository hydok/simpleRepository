package io.hydok.simplerepository.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.hydok.simplerepository.base.BaseViewModel
import io.hydok.simplerepository.model.Cat
import io.hydok.simplerepository.repository.CatRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart


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
                .onStart { Log.d("MainViewModel", "onStart") }
                .onCompletion { Log.d("MainViewModel", "onComplete") }
                .catch { Log.d("MainViewModel", "onCatch") }
                .collect { _catsData.postValue(it) }


        }
    }
}