package com.madaochan.ktweather.domain

interface Command<T> {
    fun execute(): T
}