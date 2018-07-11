package com.madaochan.ktweather.domain.model

/**
 * 用于显示在UI界面上的Model
 * @author Madao Chan
 */
data class WeatherForecast(
        // 这个Forecast是用于MVC模式的FModel
        // 作用不同于data包下的json反射类Forecast
        // 从而做到了解耦
        val date: String,
        val description: String,
        val high: Int,
        val low: Int,
        val iconUrl: String
)