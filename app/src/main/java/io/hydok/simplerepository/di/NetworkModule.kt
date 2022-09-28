package io.hydok.simplerepository.di

import com.google.gson.GsonBuilder
import io.hydok.simplerepository.data.ApiService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {

    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }
    single { GsonBuilder().setLenient().create() }
    single {
        OkHttpClient.Builder()
            .cache(get())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor {
                val request: Request = it.request().newBuilder().build()
                return@addInterceptor it.proceed(request)
            }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }


    single { get<Retrofit>().create(ApiService::class.java) }
}