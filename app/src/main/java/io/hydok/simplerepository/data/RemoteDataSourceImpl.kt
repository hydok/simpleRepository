package io.hydok.simplerepository.data

class RemoteDataSourceImpl(val apiService: ApiService): RemoteDataSource {

    override suspend fun getCatsData() = apiService.getBasicCats()


}