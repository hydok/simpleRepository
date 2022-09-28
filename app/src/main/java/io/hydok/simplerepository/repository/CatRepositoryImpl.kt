package io.hydok.simplerepository.repository

import io.hydok.simplerepository.data.LocalDataSource
import io.hydok.simplerepository.data.RemoteDataSource

class CatRepositoryImpl(private val remoteDataSource: RemoteDataSource, val localDataSource:LocalDataSource) : CatRepository {


    override suspend fun getCatsData() = remoteDataSource.getCatsData()


}