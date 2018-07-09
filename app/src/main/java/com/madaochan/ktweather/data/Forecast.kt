package com.madaochan.ktweather.data

data class Forecast(
        val dt: Long,
        val temp: Temperature,
        val pressure: Float,
        val humidity: Float,
        val weather: List<Weather>,
        val speed: Float,
        val deg: Float,
        val clouds: Int,
        val rain: Float
)