package com.madaochan.ktweather.data

data class Weather(
        val id: Long,
        val main: String,
        val description: String,
        val icon: String
)