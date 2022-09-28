package io.hydok.simplerepository.repository

import io.hydok.simplerepository.model.Cat

interface CatRepository {

   suspend fun getCatsData():List<Cat>

}