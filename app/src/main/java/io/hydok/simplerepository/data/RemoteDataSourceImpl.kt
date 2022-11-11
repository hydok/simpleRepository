package io.hydok.simplerepository.data

import io.hydok.simplerepository.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun getCatsData(): List<Cat> = apiService.getBasicCats()
    override suspend fun getCatsDataFlow(): Flow<List<Cat>> =
        flow {
            emit(apiService.getBasicCats())
        }
}
