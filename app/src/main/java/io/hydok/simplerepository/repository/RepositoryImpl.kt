package io.hydok.simplerepository.repository

import io.hydok.simplerepository.data.RemoteDataSource
import io.hydok.simplerepository.model.Cat

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {


    override suspend fun getCatsData() = remoteDataSource.getCatsData()


}