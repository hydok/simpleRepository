package io.hydok.simplerepository.data

class RemoteDataSourceImpl(private val apiService: ApiService): RemoteDataSource {

    override suspend fun getCatsData() = apiService.getBasicCats()


}