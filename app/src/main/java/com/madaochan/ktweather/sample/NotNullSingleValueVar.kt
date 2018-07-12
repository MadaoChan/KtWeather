package com.madaochan.ktweather.sample

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 一个只能赋值一次，第二次赋值就抛异常报错的类
 * 用了ReadWriteProperty
 */
class NotNullSingleValueVar<T>(): ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // 当取值为空的时候抛出一个IllegalStateException
        return value ?: throw IllegalStateException("$value not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        // 只能赋值一次，第二次赋值就抛IllegalStateException
        this.value =
                if (this.value == null) {
                    value
                } else {
                    throw IllegalStateException("${this.value} already initialized")
                }
    }
}