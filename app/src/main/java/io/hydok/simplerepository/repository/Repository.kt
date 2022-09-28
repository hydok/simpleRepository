package io.hydok.simplerepository.repository

import io.hydok.simplerepository.model.Cat

interface Repository {
   suspend fun getCatsData():List<Cat>
}