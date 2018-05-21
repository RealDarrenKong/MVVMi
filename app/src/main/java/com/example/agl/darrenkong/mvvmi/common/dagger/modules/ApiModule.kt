package com.example.agl.darrenkong.mvvmi.common.dagger.modules

import com.example.agl.darrenkong.mvvmi.common.retrofit.PetsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by darrenkong on 18/5/18.
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun providesRxJava2CallAdapterFactory(): CallAdapter.Factory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    internal fun provideIdentityOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

    @Provides
    @Singleton
    internal fun providePetsApi(okHttpClient: OkHttpClient, rXJavaFactory: CallAdapter.Factory): PetsApi {
        return Retrofit.Builder()
                .baseUrl("http://agl-developer-test.azurewebsites.net")
                .addCallAdapterFactory(rXJavaFactory)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(PetsApi::class.java)
    }
}