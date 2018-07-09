package com.madaochan.ktweather.domain

import android.util.Log
import com.madaochan.ktweather.data.Forecast
import com.madaochan.ktweather.domain.model.ForecastList
import com.madaochan.ktweather.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.madaochan.ktweather.domain.model.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        Log.e(javaClass.simpleName, forecast.list.size.toString())
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
        Log.e(javaClass.simpleName, forecast.weather[0].description)
        return ModelForecast(
                forecast.datetimeText,
                forecast.weather[0].description,
                forecast.temp.temp_max.toInt(),
                forecast.temp.temp_min.toInt()
        )
    }

    private fun convertDate(date: Long): String {
        val dt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return dt.format(date * 1000)
    }
}