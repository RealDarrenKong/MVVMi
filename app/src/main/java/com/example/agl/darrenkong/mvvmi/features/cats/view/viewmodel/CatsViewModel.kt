package com.example.agl.darrenkong.mvvmi.features.cats.view.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.example.agl.darrenkong.mvvmi.common.BaseViewModel
import com.example.agl.darrenkong.mvvmi.common.disposables
import com.example.agl.darrenkong.mvvmi.features.cats.interactor.CatsInteractor
import com.example.agl.darrenkong.mvvmi.features.cats.model.CatNameItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by darrenkong on 16/5/18.
 */
class CatsViewModel
@Inject constructor(val catsInteractor: CatsInteractor) : BaseViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val sortedData = MutableLiveData<List<CatNameItem>>()

    /**
     * Display loading screen while fetching cats data from the server
     */
    fun geCatsData() {
        disposables.add(
                catsInteractor.getListOfCatsByGender()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { isLoading.value = true }
                        .doAfterTerminate { isLoading.value = false }
                        .subscribe({ cats ->
                            sortedData.value = cats
                        }, { e ->
                            error.value = e
                        })
        )
    }

}