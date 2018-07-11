package com.madaochan.ktweather.domain.model

data class ForecastList(
        val city: String,
        val country: String,
        val hourForecastList: List<WeatherForecast>) {

    operator fun get(position: Int) = hourForecastList[position]

    fun size() = hourForecastList.size
}