package com.example.agl.darrenkong.mvvmi.common.dagger.modules


import com.example.agl.darrenkong.mvvmi.MvvmiApplication
import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by darrenkong on 27/8/17.
 */

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (ApiModule::class), (UiModule::class), (BuildersModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MvvmiApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvvmiApplication)
}