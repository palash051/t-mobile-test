package com.jahirul.tmobileexercise.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.jahirul.tmobileexercise.businesslogic.Cards
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import com.jahirul.tmobileexercise.di.component.DaggerApiComponent
import com.jahirul.tmobileexercise.businesslogic.PhotosService
import com.jahirul.tmobileexercise.businesslogic.DataModel

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class FeatureViewModel : ViewModel() {

    @Inject
    lateinit var photosService: PhotosService
    private val disposable = CompositeDisposable()
    val photos = MutableLiveData<DataModel>()
    val photosLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun refresh(context: Context) {
        fetchPhotos(context)
    }

    private fun fetchPhotos(context: Context) {
        loading.value = true
        doAsync {
            uiThread {
                disposable.add(
                    photosService.getPhotos().subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<DataModel>() {
                            override fun onSuccess(value: DataModel?) {
                                setDataOnSuccess(value)
                            }

                            override fun onError(e: Throwable?) {
                                photosLoadError.value = true
                                loading.value = false
                            }
                        })
                )
            }
        }
    }

    private fun setDataOnSuccess(value: DataModel?) {
        photos.value = value
        photosLoadError.value = false
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}
