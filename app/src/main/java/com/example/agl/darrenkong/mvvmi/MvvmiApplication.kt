package com.example.agl.darrenkong.mvvmi

import android.app.Activity
import android.app.Application
import com.example.agl.darrenkong.mvvmi.common.dagger.modules.AppComponent
import com.example.agl.darrenkong.mvvmi.common.dagger.modules.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by darrenkong on 18/5/18.
 */
class MvvmiApplication : Application(), HasActivityInjector {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic
        lateinit var graph: AppComponent
    }

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }
}