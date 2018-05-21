package com.example.agl.darrenkong.mvvmi.common.dagger.modules

import com.example.agl.darrenkong.mvvmi.features.cats.view.ui.CatsActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [(CatsModule::class)])
    internal abstract fun bindCatsActivity(): CatsActivity

    // Add bindings for other sub-components here
}
