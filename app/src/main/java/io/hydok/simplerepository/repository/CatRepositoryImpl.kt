package io.hydok.simplerepository.repository

import io.hydok.simplerepository.data.LocalDataSource
import io.hydok.simplerepository.data.RemoteDataSource
import io.hydok.simplerepository.model.Cat
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
        .catch {
            // TODO: Local data loaad
            //emit()
        }
}