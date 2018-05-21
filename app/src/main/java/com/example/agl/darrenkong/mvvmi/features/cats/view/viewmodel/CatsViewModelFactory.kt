package com.example.agl.darrenkong.mvvmi.features.cats.view.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.agl.darrenkong.mvvmi.features.cats.interactor.CatsInteractor
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
/**
 * Created by darrenkong on 18/5/18.
 */
class CatsViewModelFactory
@Inject constructor(val catsInteractor: CatsInteractor) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatsViewModel::class.java)) {
            return CatsViewModel(catsInteractor) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}