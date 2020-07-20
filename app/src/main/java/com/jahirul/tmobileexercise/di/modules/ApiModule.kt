package com.jahirul.tmobileexercise.di.modules

import dagger.Module
import dagger.Provides
import com.jahirul.tmobileexercise.businesslogic.PhotosApi
import com.jahirul.tmobileexercise.businesslogic.PhotosService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/"

    @Provides
    fun providePhotosApi(): PhotosApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PhotosApi::class.java)
    }

    @Provides
    fun providePhotosService(): PhotosService {
        return PhotosService()
    }

}