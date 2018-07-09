package com.madaochan.ktweather.data

data class ForecastResult(
        val cod: String,
        val message: Float,
        val cnt: Int,
        val city: City,
        val list: List<Forecast>
)