package io.hydok.simplerepository.data

import io.hydok.simplerepository.model.Cat
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getCatsData(): List<Cat>

    suspend fun getCatsDataFlow(): Flow<List<Cat>>
}