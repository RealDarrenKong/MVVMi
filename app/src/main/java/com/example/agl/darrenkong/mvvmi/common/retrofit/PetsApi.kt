package com.example.agl.darrenkong.mvvmi.common.retrofit

import com.example.agl.darrenkong.mvvmi.common.models.OwnerAndPets
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by darrenkong on 17/5/18.
 */

/**
 * Created by micelit on 1/12/2016.
 */

interface PetsApi {
    @GET("/people.json")
    fun getOwnersAndPets(): Single<List<OwnerAndPets>>
}
