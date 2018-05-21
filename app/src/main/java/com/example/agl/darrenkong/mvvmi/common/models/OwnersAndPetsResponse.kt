package com.example.agl.darrenkong.mvvmi.common.models

import com.example.agl.darrenkong.mvvmi.common.enums.GenderType
import com.example.agl.darrenkong.mvvmi.common.enums.PetType

/**
 * Created by darrenkong on 17/5/18.
 */
data class OwnerAndPets(val name: String, val gender: GenderType, val age : Int, val pets: List<Pets>?)

data class Pets(val name: String, val type: PetType)