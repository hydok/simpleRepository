package io.hydok.simplerepository.repository

import io.hydok.simplerepository.model.Cat
import kotlinx.coroutines.flow.Flow

interface CatRepository {

    suspend fun getCatsData(): List<Cat>

    suspend fun getCatsDataFlow(): Flow<List<Cat>>

}