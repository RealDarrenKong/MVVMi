package com.example.agl.darrenkong.mvvmi.common.models

import com.example.agl.darrenkong.mvvmi.common.enums.GenderType
import com.example.agl.darrenkong.mvvmi.common.enums.PetType

/**
 * Created by darrenkong on 17/5/18.
 */
data class PetsAndOwnerGender(val petType: PetType, val petName: String, val ownerGender: GenderType)