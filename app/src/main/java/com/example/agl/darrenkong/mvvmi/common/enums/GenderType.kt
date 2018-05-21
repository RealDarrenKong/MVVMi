package com.example.agl.darrenkong.mvvmi.common.enums

import com.squareup.moshi.Json

/**
 * Created by darrenkong on 17/5/18.
 */

enum class GenderType {
    @Json(name = "Male")
    MALE,
    @Json(name = "Female")
    FEMALE
}