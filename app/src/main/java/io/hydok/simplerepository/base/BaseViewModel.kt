package io.hydok.simplerepository.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

/**
* Base
* @author hydok
* @version 1.0.0
* @since 2022/09/28 11:17 오전
**/
abstract class BaseViewModel : ViewModel() {
    private val _fetchState = MutableLiveData<FetchState>()
    val fetchState : LiveData<FetchState>
        get() = _fetchState

    private val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()

        when(throwable){
            is SocketException -> _fetchState.postValue(FetchState.INTERNET_ERROR)
            is HttpException -> _fetchState.postValue(FetchState.PARSE_ERROR)
            is UnknownHostException -> _fetchState.postValue(FetchState.WRONG_CONNECTION)
            else -> _fetchState.postValue(FetchState.FAIL)
        }
    }

    open fun launchViewModelScope(doWork: suspend () -> Unit) =
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO + exceptionHandler) {
            doWork()
        }
}

enum class FetchState {
    INTERNET_ERROR,PARSE_ERROR,WRONG_CONNECTION,FAIL
}