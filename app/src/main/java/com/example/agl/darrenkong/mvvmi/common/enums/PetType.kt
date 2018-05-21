package com.example.agl.darrenkong.mvvmi.common.enums

import com.squareup.moshi.Json

/**
 * Created by darrenkong on 17/5/18.
 */
enum class PetType {
    @Json(name = "Dog")
    DOG,
    @Json(name = "Cat")
    CAT,
    @Json(name = "Fish")
    FISH
}