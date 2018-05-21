package com.example.agl.darrenkong.mvvmi.features.cats.model

import com.example.agl.darrenkong.mvvmi.common.models.PetsAndOwnerGender

/**
 * Created by darrenkong on 16/5/18.
 */

data class CatsByOwnerGender(val catsOwnerByMale: List<PetsAndOwnerGender>, val catsOwnerByFemale: List<PetsAndOwnerGender>)