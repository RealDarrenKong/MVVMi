package com.example.agl.darrenkong.mvvmi.common.dagger.modules

import com.example.agl.darrenkong.mvvmi.features.cats.interactor.CatsInteractor
import com.example.agl.darrenkong.mvvmi.features.cats.view.viewmodel.CatsViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by darrenkong on 18/5/18.
 */
@Module
class UiModule {

    @Provides
    @Singleton
    internal fun provideCatsViewModelFactory(catsInteractor: CatsInteractor): CatsViewModelFactory {
        return CatsViewModelFactory(catsInteractor)
    }

}
