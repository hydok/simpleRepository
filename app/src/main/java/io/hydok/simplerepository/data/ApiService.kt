package io.hydok.simplerepository.data

import io.hydok.simplerepository.model.Cat
import retrofit2.http.GET

interface ApiService {

    @GET("v1/images/search?limit=10")
    suspend fun getBasicCats(): List<Cat>

}