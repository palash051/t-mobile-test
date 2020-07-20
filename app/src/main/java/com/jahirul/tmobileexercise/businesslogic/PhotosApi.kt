package com.jahirul.tmobileexercise.businesslogic

import io.reactivex.Single
import retrofit2.http.GET

interface PhotosApi {

    @GET("test/home")
    fun getPhotos():Single<DataModel>
}