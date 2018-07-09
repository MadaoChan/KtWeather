package com.madaochan.ktweather.network

import android.util.Log
import com.google.gson.Gson
import com.madaochan.ktweather.data.ForecastResult
import java.net.URL

class ForecastRequest(val cityName: String) {
    companion object {
        private const val APP_ID = "906896e9b3012f8387ef44f69c194fd8"
        private const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/" +
                "forecast?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$WEATHER_URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val url = COMPLETE_URL + cityName
//        val forecastJsonStr = URL(url).readText()
//        Log.e(javaClass.simpleName, forecastJsonStr)
        val forecastJsonStr = "{\"cod\":\"200\",\"message\":0.006,\"cnt\":7,\"list\":[{\"dt\":1531137600,\"main\":{\"temp\":28.02,\"temp_min\":27.31,\"temp_max\":28.02,\"pressure\":1010.91,\"sea_level\":1019.61,\"grnd_level\":1010.91,\"humidity\":82,\"temp_kf\":0.72},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":68},\"wind\":{\"speed\":2.86,\"deg\":119.001},\"rain\":{\"3h\":1.125},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-07-09 12:00:00\"},{\"dt\":1531148400,\"main\":{\"temp\":25.73,\"temp_min\":25.19,\"temp_max\":25.73,\"pressure\":1012.28,\"sea_level\":1021,\"grnd_level\":1012.28,\"humidity\":88,\"temp_kf\":0.54},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.26,\"deg\":112.506},\"rain\":{\"3h\":1.16},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-07-09 15:00:00\"},{\"dt\":1531159200,\"main\":{\"temp\":24.37,\"temp_min\":24.01,\"temp_max\":24.37,\"pressure\":1011.08,\"sea_level\":1019.93,\"grnd_level\":1011.08,\"humidity\":92,\"temp_kf\":0.36},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.16,\"deg\":66.5071},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-07-09 18:00:00\"},{\"dt\":1531170000,\"main\":{\"temp\":23.07,\"temp_min\":22.89,\"temp_max\":23.07,\"pressure\":1010.17,\"sea_level\":1018.93,\"grnd_level\":1010.17,\"humidity\":94,\"temp_kf\":0.18},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.21,\"deg\":20.5009},\"rain\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2018-07-09 21:00:00\"},{\"dt\":1531180800,\"main\":{\"temp\":26.66,\"temp_min\":26.66,\"temp_max\":26.66,\"pressure\":1010.63,\"sea_level\":1019.44,\"grnd_level\":1010.63,\"humidity\":89,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.86,\"deg\":20.5058},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2018-07-10 00:00:00\"},{\"dt\":1531191600,\"main\":{\"temp\":31.21,\"temp_min\":31.21,\"temp_max\":31.21,\"pressure\":1010.5,\"sea_level\":1019.19,\"grnd_level\":1010.5,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.41,\"deg\":70.5054},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2018-07-10 03:00:00\"},{\"dt\":1531202400,\"main\":{\"temp\":32.91,\"temp_min\":32.91,\"temp_max\":32.91,\"pressure\":1008.57,\"sea_level\":1017.24,\"grnd_level\":1008.57,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":20},\"wind\":{\"speed\":2.32,\"deg\":106.5},\"rain\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2018-07-10 06:00:00\"}],\"city\":{\"id\":1809858,\"name\":\"Guangzhou\",\"coord\":{\"lat\":23.1302,\"lon\":113.2593},\"country\":\"CN\",\"population\":3152825}}"
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}