package com.madaochan.ktweather.domain

import com.madaochan.ktweather.domain.model.ForecastList
import com.madaochan.ktweather.network.ForecastRequest

/**
 * 请求天气的指令基类
 */
class RequestForecastCommand(private val cityName: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val request = ForecastRequest(cityName)
        val result = request.execute()
        return ForecastDataMapper().convertFromDataModel(result)
    }
}