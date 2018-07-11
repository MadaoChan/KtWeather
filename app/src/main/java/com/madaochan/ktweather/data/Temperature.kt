package com.madaochan.ktweather.data

import com.google.gson.annotations.SerializedName

data class Temperature(
        val temp: Float,
        @SerializedName("temp_min") val temp_min: Float,
        @SerializedName("temp_max") val temp_max: Float,
        val pressure: Float,
        val sea_level: Float,
        val grnd_level: Float,
        val humidity: Float,
        @SerializedName("temp_kf") val tempKf: Float
//        val morning: Float,
//        val day: Float,
//        val night: Float,
//        val eve: Float
)