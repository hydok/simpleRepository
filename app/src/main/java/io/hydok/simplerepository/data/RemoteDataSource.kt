package io.hydok.simplerepository.data

import io.hydok.simplerepository.model.Cat

interface RemoteDataSource {
    suspend fun getCatsData():List<Cat>
}