package io.hydok.simplerepository.repository

import io.hydok.simplerepository.data.LocalDataSource
import io.hydok.simplerepository.data.RemoteDataSource
import io.hydok.simplerepository.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CatRepositoryImpl(private val remoteDataSource: RemoteDataSource, val localDataSource:LocalDataSource) : CatRepository {


    override suspend fun getCatsData() = remoteDataSource.getCatsData()

    override suspend fun getCatsDataFlow() = remoteDataSource.getCatsDataFlow()
}