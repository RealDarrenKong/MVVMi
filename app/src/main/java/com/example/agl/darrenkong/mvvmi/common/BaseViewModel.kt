package com.example.agl.darrenkong.mvvmi.common

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by darrenkong on 16/5/18.
 */

val disposables: CompositeDisposable = CompositeDisposable()

//Base class used to provide common functions and variables for View Model classes
open class BaseViewModel : ViewModel() {

    val error = MutableLiveData<Throwable>()

    public override fun onCleared() {
        disposables.clear()
    }

}