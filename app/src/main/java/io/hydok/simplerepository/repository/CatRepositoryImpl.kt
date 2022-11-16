package io.hydok.simplerepository.repository

import android.util.Log
import io.hydok.simplerepository.data.LocalDataSource
import io.hydok.simplerepository.data.RemoteDataSource
import kotlinx.coroutines.flow.*

class CatRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    val localDataSource: LocalDataSource
) : CatRepository {


    override suspend fun getCatsData() = remoteDataSource.getCatsData()

    override suspend fun getCatsDataFlow() = remoteDataSource.getCatsDataFlow()
        .map { cat -> 
            // TODO: Filter
            cat
        }
        .onEach {
            // TODO: Local Save
        }
        .catch { exception ->
            // TODO: Local data loaad
            Log.d("Error?", exception.toString())
            //emit()
        }
}