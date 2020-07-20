package com.jahirul.tmobileexercise.di.component

import dagger.Component
import com.jahirul.tmobileexercise.di.modules.ApiModule
import com.jahirul.tmobileexercise.businesslogic.PhotosService
import com.jahirul.tmobileexercise.viewmodel.FeatureViewModel

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: PhotosService)

    fun inject(viewModel:FeatureViewModel)

}