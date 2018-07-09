package com.madaochan.ktweather.data

import com.google.gson.annotations.SerializedName

data class Rain (
        @SerializedName("3h") val threeHours: Float
)