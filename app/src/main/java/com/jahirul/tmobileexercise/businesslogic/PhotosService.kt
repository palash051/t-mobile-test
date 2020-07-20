package com.jahirul.tmobileexercise.businesslogic

import io.reactivex.Single
import com.jahirul.tmobileexercise.di.component.DaggerApiComponent
import javax.inject.Inject

class PhotosService {

    @Inject
    lateinit var api: PhotosApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getPhotos():Single<DataModel>{
        return api.getPhotos()
    }
}