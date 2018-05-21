package com.example.agl.darrenkong.mvvmi.common.repositories

import com.example.agl.darrenkong.mvvmi.common.models.OwnerAndPets
import com.example.agl.darrenkong.mvvmi.common.retrofit.PetsApi
import com.example.agl.darrenkong.mvvmi.common.models.PetsAndOwnerGender
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by darrenkong on 17/5/18.
 */

class PetsRepository
@Inject constructor(val petsApi: PetsApi) {
    fun getPets(): Single<List<PetsAndOwnerGender>> {
        return petsApi.getOwnersAndPets().map { mapResults(it) }
    }

    private fun mapResults(ownersAndPetsList: List<OwnerAndPets>): List<PetsAndOwnerGender> {
        val listPets = ArrayList<PetsAndOwnerGender>()

        for (owner in ownersAndPetsList) {
            owner.pets?.mapTo(listPets) { PetsAndOwnerGender(it.type, it.name, owner.gender) }
        }

        return listPets
    }
}

