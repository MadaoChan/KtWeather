package com.madaochan.ktweather.domain

import com.madaochan.ktweather.data.Forecast
import com.madaochan.ktweather.domain.model.ForecastList
import com.madaochan.ktweather.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.madaochan.ktweather.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(
                forecast.city.name,
                forecast.city.country,
                convertForecastListToDomain(forecast.list)
        )
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                convertDate(forecast.dt),
                forecast.weather[0].description,
                forecast.temp.max.toInt(),
                forecast.temp.min.toInt()
        )
    }

    private fun convertDate(date: Long): String {
        val dt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dt.format(date * 1000)
    }
}