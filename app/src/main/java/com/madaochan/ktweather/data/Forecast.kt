package com.madaochan.ktweather.data

import com.google.gson.annotations.SerializedName

data class Forecast(
        val dt: Long,
        @SerializedName("main") val temp: Temperature,
        val pressure: Float,
        val humidity: Float,
        val weather: List<Weather>,
        val clouds: Clouds,
        val rain: Rain,
        val sys: Sys,
        @SerializedName("dt_txt") val datetimeText: String
//        val clouds: Int,
//        val rain: Float
)